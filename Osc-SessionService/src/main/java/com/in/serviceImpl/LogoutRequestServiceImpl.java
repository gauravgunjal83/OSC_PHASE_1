package com.in.serviceImpl;

import com.in.Session.SessionServiceGrpc;
import com.in.Session.SessionStatusResponse;
import com.in.avro.SessionKey;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.LogoutRequestDto;
import com.in.dto.SessionRequestDto;
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
    public DataResponse logoutUser(LogoutRequestDto logoutRequest) {
        try {
            // Validate the session via gRPC call
            SessionStatusResponse sessionResponse = serviceBlockingStub.validateSession(Mapper.logoutReqDtoToValidateSessionReqProto(logoutRequest));

            if (!Mapper.sessionStatusResponseProtoToDto(sessionResponse)) {
                log.warn("Session already logged out or invalid sessionId: {}", logoutRequest.getSessionId());
                return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, null);
            }
            // Create a request to update session status to false (logged out)
            SessionRequestDto sessionUpdateRequest = new SessionRequestDto(
                    createSessionKey(sessionResponse.getUserId(), sessionResponse.getDeviceType()),
                    false);

            // Publish the session update to Kafka
            sessionKafkaProducer.publishToSessionTopic(sessionUpdateRequest);
            log.info("Session successfully logged out for sessionId: {}", logoutRequest.getSessionId());
            return new DataResponse(CustomStatusCodes.LOGOUT_SUCCESS, "Session successfully logged out.");
        } catch (StatusRuntimeException e) {
            if (e.getStatus().getCode() == io.grpc.Status.Code.NOT_FOUND) {
                log.error("Session not found for sessionId: {}", logoutRequest.getSessionId());
                return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "SessionId not found.");
            }
            log.error("gRPC call failed with status: {}", e.getStatus(), e);
        } catch (Exception e) {
            log.error("Unexpected error during logout request for sessionId: {}", logoutRequest.getSessionId(), e);
        }

        return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "Internal server error. Please try again later.");
    }

    // Helper method to create a session key for Kafka
    private static SessionKey createSessionKey(String userId, String deviceType) {
        return SessionKey.newBuilder()
                .setUserId(userId)
                .setDeviceType(deviceType)
                .build();

    }
}
