package com.in.grpcService;

import com.in.Session.*;
import com.in.dto.LogoutResponseDto;
import com.in.dto.SessionResponseDto;
import com.in.exception.RecordNotFoundException;
import com.in.mapper.Mapper;
import com.in.service.LoginRequestService;
import com.in.service.LogoutRequestService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class SessionData_Grpc_Service extends SessionServiceGrpc.SessionServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(SessionData_Grpc_Service.class);
    private final LoginRequestService loginService;
    private final LogoutRequestService logoutService;

    public SessionData_Grpc_Service(LoginRequestService loginService, LogoutRequestService logoutService) {
        this.loginService = loginService;
        this.logoutService = logoutService;
    }

    @Override
    public void createSession(CreateSessionRequest request, StreamObserver<CreateSessionResponse> responseObserver) {
        try {
            SessionResponseDto sessionResponse = loginService.createSession(Mapper.requestToCreateSessionDto(request));
            log.info("Session data successfully stored in database{}", sessionResponse);
            responseObserver.onNext(Mapper.dtoToCreateSessionResponseProto(sessionResponse));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error while creating Session")
                    .withCause(new RecordNotFoundException("Error occurs while creating Session")).asRuntimeException());
        }
    }

    @Override
    public void validateSession(ValidateSessionRequest request, StreamObserver<SessionStatusResponse> responseObserver) {
        try {
            // Validate session using the login service
            LogoutResponseDto session = logoutService.logoutUser(Mapper.validateSessionReqProtoToLogoutReqDto(request));
            if (session.isLogout()) {
                log.info("Session logged out successfully, sessionId: {}", request.getSessionId());
            } else {
                log.info("Session is not active, sessionId: {}", request.getSessionId());
            }

            // Map and send the session status response
            responseObserver.onNext(Mapper.logoutResponseDtoToSessionStatusResProto(session));
            responseObserver.onCompleted();
        } catch (RecordNotFoundException e) {
            log.error("Session not found for sessionId: {}", request.getSessionId());
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Session not found for sessionId: " + request.getSessionId())
                            .asRuntimeException()
            );
        } catch (IllegalArgumentException e) {
            log.error("Invalid request for sessionId: {}", request.getSessionId());
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Invalid session request for sessionId: " + request.getSessionId())
                            .asRuntimeException()
            );
        } catch (RuntimeException e) {
            log.error("Unexpected error validating session for sessionId: {}", request.getSessionId());
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription("Unexpected error occurred")
                            .asRuntimeException()
            );
        }

    }

}
