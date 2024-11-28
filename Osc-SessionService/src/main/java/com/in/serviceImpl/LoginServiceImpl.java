package com.in.serviceImpl;

import com.in.Session.CreateSessionResponse;
import com.in.Session.SessionServiceGrpc;
import com.in.avro.SessionKey;
import com.in.avro.SessionValue;
import com.in.config.UtilConfig;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.LoginRequestDto;
import com.in.dto.SessionRequestDto;
import com.in.kafka.producer.SessionKafkaProducer;
import com.in.mapper.Mapper;
import com.in.proto.UserDataServiceGrpc;
import com.in.proto.VerifyCredentialsResponse;
import com.in.service.LoginService;
import io.grpc.StatusRuntimeException;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final SessionKafkaProducer sessionKafkaProducer;
    private final UserDataServiceGrpc.UserDataServiceBlockingStub userDataServiceBlockingStub;
    private final SessionServiceGrpc.SessionServiceBlockingStub sessionServiceBlockingStub;
    private final UtilConfig.SessionIdGenerator sessionIdGenerator;
    private ReadOnlyKeyValueStore<SessionKey, SessionValue> sessionStore;

    public LoginServiceImpl(SessionKafkaProducer sessionKafkaProducer, UserDataServiceGrpc.UserDataServiceBlockingStub userDataServiceBlockingStub, SessionServiceGrpc.SessionServiceBlockingStub sessionServiceBlockingStub, UtilConfig.SessionIdGenerator sessionIdGenerator, ReadOnlyKeyValueStore<SessionKey, SessionValue> sessionStore) {
        this.sessionKafkaProducer = sessionKafkaProducer;
        this.userDataServiceBlockingStub = userDataServiceBlockingStub;
        this.sessionServiceBlockingStub = sessionServiceBlockingStub;
        this.sessionIdGenerator = sessionIdGenerator;
        this.sessionStore = sessionStore;
    }

    @Override
    public DataResponse loginRequest(LoginRequestDto loginRequest) {
        try {
            VerifyCredentialsResponse verifyCredentials = userDataServiceBlockingStub.verifyCredentials(Mapper.loginReqDtoToProto(loginRequest));
            if (verifyCredentials != null && verifyCredentials.getPassword() != null) {
                log.info("Credentials are matched for userId {}", loginRequest.getUserId());
                //Check for credentials
                if (!verifyCredentials.getPassword().equals(loginRequest.getPassword())) {
                    log.error("Password is incorrect for userId: {}", loginRequest.getUserId());
                    return new DataResponse(CustomStatusCodes.PASSWORD_INCORRECT, "Password is incorrect");
                }
                //check for session are exists with same device or not
                SessionValue session = sessionStore.get(createSessionId(loginRequest.getUserId(), loginRequest.getLoginDeviceType()));
                if (session != null && session.getSessionStatus() == true) {
                    log.error("Session already active for this userId {}", loginRequest.getUserId());
                    log.info("You are not able to login if session active with same device");
                    return new DataResponse(CustomStatusCodes.ACTIVE_SESSION,  "Session is already active...");
                } else {
                    String sessionId = sessionIdGenerator.generateSessionId();

                    //if session is not active for user then create a new session
                    CreateSessionResponse response = sessionServiceBlockingStub.createSession(Mapper.requestToCreateSessionResponse(sessionId, loginRequest.getUserId(), loginRequest.getLoginDeviceType()));
                    log.info("new session created for userId {}", loginRequest.getUserId());
                    log.info("session status {}", response.getSuccess());

                    SessionRequestDto requestDto = new SessionRequestDto(
                            createSessionId(loginRequest.getUserId(), loginRequest.getLoginDeviceType()), true);
                    sessionKafkaProducer.publishToSessionTopic(requestDto);
                    return new DataResponse(CustomStatusCodes.LOGIN_SUCCESS, Map.of("sessionId", sessionId, "name", verifyCredentials.getName()));
                }
            } else {
                log.error("Invalid UserId {}", loginRequest.getUserId());
                return new DataResponse(CustomStatusCodes.USERID_INCORRECT, null);
            }
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == io.grpc.Status.Code.NOT_FOUND) {
                log.error("User id not found: {}", loginRequest.getUserId());
                return new DataResponse(CustomStatusCodes.USERID_INCORRECT, "User ID not found");
            }
        }
        return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "Internal server error");

    }

    // for set key in session-topic
    public static SessionKey createSessionId(String userId, String deviceName) {
        return SessionKey.newBuilder()
                .setUserId(userId)
                .setDeviceType(deviceName).build();
    }
}
