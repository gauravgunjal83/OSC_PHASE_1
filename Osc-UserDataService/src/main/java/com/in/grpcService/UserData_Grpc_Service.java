package com.in.grpcService;

import com.in.dto.UserLoginDto;
import com.in.dto.UserRegistrationRequestDto;
import com.in.exception.RecordNotFound;
import com.in.mapper.Mapper;
import com.in.proto.*;
import com.in.service.UserDataService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
//@RequiredArgsConstructor
public class UserData_Grpc_Service extends UserDataServiceGrpc.UserDataServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(UserData_Grpc_Service.class);
    private final UserDataService userDataService;

    public UserData_Grpc_Service(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @Override
    public void registerUser(RegisterUserRequest request, StreamObserver<RegisterUserResponse> responseObserver) {
       /* try {
            UserRegistrationRequestDto user = userDataService.createUser(Mapper.requestToDto(request));
            log.info("user successfully store into database");
            responseObserver.onNext(Mapper.dtoToResponse(user));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error in saving user details...").withCause(new RecordNotFound("Error in saving user")).asRuntimeException());
        }*/
        try {
            log.info("Received RegisterUserRequest: {}", request);
            UserRegistrationRequestDto userDto = Mapper.requestToDto(request);
            log.info("Mapped to UserRegistrationRequestDto: {}", userDto);
            UserRegistrationRequestDto user = userDataService.createUser(userDto);
            log.info("User successfully stored into database: {}", user);

            RegisterUserResponse response = Mapper.dtoToResponse(user);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("Error while saving user details", e);
            responseObserver.onError(
                    Status.INTERNAL.withDescription("Error in saving user details...")
                            .withCause(e)
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void verifyEmailAddressIsUnique(UniqueEmailRequest request, StreamObserver<UniqueEmailResponse> responseObserver) {
 /*  try {
            boolean emailExist = userDataService.isEmailAddressExists(Mapper.requestToDto(request));
            if (emailExist)
                log.error("'" + request.getEmail() + "' is all ready register...!");
            responseObserver.onNext(Mapper.dtoToResponse(!emailExist));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("An error occurred while processing the request.")
                    .withCause(e)
                    .asRuntimeException());
    }
*/
        try {
            log.info("Checking email uniqueness for: {}", request.getEmail());
            boolean emailExists = userDataService.isEmailAddressExists(Mapper.requestToDto(request));
            if (emailExists) {
                log.warn("Email '{}' is already registered.", request.getEmail());
            } else {
                log.info("Email '{}' is unique.", request.getEmail());
            }
            UniqueEmailResponse response = UniqueEmailResponse.newBuilder()
                    .setIsUnique(!emailExists)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            log.error("Error occurred while checking email uniqueness", e);
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription("An error occurred while processing the request.")
                            .withCause(e)
                            .asRuntimeException()
            );
        }

    }

    @Override
    public void verifyCredentials(VerifyCredentialsRequest request, StreamObserver<VerifyCredentialsResponse> responseObserver) {
        try {
            log.info("verify credential request in userDataService");
            UserLoginDto loginDetails = userDataService.userLoginDetails(request.getUserId());
            responseObserver.onNext(Mapper.dtoToVerifyCredentialsResponse(loginDetails));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            log.error("User id is incorrect :{}",request.getUserId());
            responseObserver.onError(Status.NOT_FOUND.withDescription("User id is incorrect!!")
                    .withCause(new RecordNotFound("User id is incorrect")).asRuntimeException());
        }
    }

    @Override
    public void isEmailPresent(UniqueEmailRequest request, StreamObserver<UniqueEmailResponse> responseObserver) {
        try {
            boolean emailExists = userDataService.isEmailAddressExists(Mapper.requestToDto(request));
            if (!emailExists)
                log.error("this email is not valid " + request.getEmail());
            responseObserver.onNext(Mapper.dtoToResponse(emailExists));
            responseObserver.onCompleted();

        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error is occur while processing the request ").withCause(e).asRuntimeException());
        }
    }

    @Override
    public void resetPassword(PasswordRequest request, StreamObserver<PasswordResponse> responseObserver) {
        try {
            log.info("Processing password reset for email: {}", request.getEmail());
            boolean isUpdate = userDataService.changePassword(Mapper.passwordReqProtoToChangePasswordDto(request));
            responseObserver.onNext(Mapper.booleanToPasswordResponseProto(isUpdate));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            log.error("Failed to reset password for email: {}", request.getEmail(), e);
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("User not found. Failed to update password.")
                            .withCause(new RecordNotFound("User not found for updating password"))
                            .asRuntimeException()
            );
        }

       /* try {
            log.info("update password !!");
            boolean isChange = userDataService.changePassword(Mapper.passwordReqProtoToChangePasswordDto(request));
            PasswordResponse response = Mapper.booleanToPasswordResponseProto(isChange);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("User not found.. failed to update password")
                    .withCause(new RecordNotFound("User not found for updating password")).asRuntimeException());
        }*/
    }
}
