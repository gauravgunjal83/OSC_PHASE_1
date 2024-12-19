package com.in.serviceImpl;

import com.in.Session.SessionServiceGrpc;
import com.in.Session.SessionStatusResponse;
import com.in.avro.SessionKey;
import com.in.dto.*;
import com.in.kafka.producer.SessionKafkaProducer;
import com.in.mapper.Mapper;
import com.in.service.LogoutRequestService;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogoutRequestServiceImpl implements LogoutRequestService {
    private static final Logger log = LoggerFactory.getLogger(LogoutRequestServiceImpl.class);

    private final SessionKafkaProducer sessionKafkaProducer;
    private final SessionServiceGrpc.SessionServiceBlockingStub serviceBlockingStub;

    public LogoutRequestServiceImpl(SessionKafkaProducer sessionKafkaProducer, SessionServiceGrpc.SessionServiceBlockingStub serviceBlockingStub) {
        this.sessionKafkaProducer = sessionKafkaProducer;
        this.serviceBlockingStub = serviceBlockingStub;
    }

    @Override
    public ResponseCode logoutUser(LogoutRequestDto logoutRequest) {
        try {
            SessionStatusResponse sessionResponse = serviceBlockingStub.validateSession(Mapper.logoutReqDtoToValidateSessionReqProto(logoutRequest));
            if (!Mapper.sessionStatusResponseProtoToDto(sessionResponse)) {
                log.warn("Session already logged out or invalid sessionId: {}", logoutRequest.getSessionId());
                return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
            }
            SessionRequestDto sessionUpdateRequest = new SessionRequestDto(
                    createSessionKey(sessionResponse.getUserId(), sessionResponse.getDeviceType()),
                    false);

            sessionKafkaProducer.publishToSessionTopic(sessionUpdateRequest);
            log.info("Session successfully logged out for sessionId: {}", logoutRequest.getSessionId());
            return new ResponseCode(CustomStatusCodes.LOGOUT_SUCCESS);
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == io.grpc.Status.Code.NOT_FOUND) {
                log.error("Session not found for sessionId: {}", logoutRequest.getSessionId());
                return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
            }
            log.error("gRPC call failed with status: {}", e.getStatus(), e);
        } catch (Exception e) {
            log.error("Unexpected error during logout request for sessionId: {}", logoutRequest.getSessionId(), e);
        }

        return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
    }

    private static SessionKey createSessionKey(String userId, String deviceType) {
        return SessionKey.newBuilder()
                .setUserId(userId)
                .setDeviceType(deviceType)
                .build();

    }
}
