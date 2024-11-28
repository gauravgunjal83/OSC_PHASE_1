package com.in.mapper;

import com.in.avro.OtpMessage;
import com.in.avro.User;
import com.in.config.DateConfig;
import com.in.dto.*;
import com.in.proto.PasswordRequest;
import com.in.proto.RegisterUserRequest;
import com.in.proto.UniqueEmailRequest;
import com.in.proto.UniqueEmailResponse;

public class Mapper {

    public static final String REGISTRATION = "USER_REGISTRATION";
    public static final String RESET_PASSWORD = "RESET_PASSWORD";

    public static Boolean responseToDto(UniqueEmailResponse uniqueEmailResponse) {
        return uniqueEmailResponse.getIsUnique();
    }

    public static User requestToUser(RegistrationRequest registrationRequest) {
        return new User(registrationRequest.getName(),
                registrationRequest.getEmail(),
                DateConfig.localDateToString(registrationRequest.getDOB())
                , registrationRequest.getContact());
    }

    public static UniqueEmailRequest emailToRequest(String email) {
        return UniqueEmailRequest.newBuilder().setEmail(email).build();
    }

    public static OtpMessage requestToOtp(OtpVerificationRequest request) {
        return new OtpMessage(request.getOTP(),
                request.getEmail(), request.getFailedOtpAttempts(), REGISTRATION);
    }

    public static RegistrationResponse dtoToRegistrationResponseDto(String userId, User user, SetPasswordRequest request) {
        return new RegistrationResponse(userId,
                user.getName().toString(),
                user.getEmail().toString(),
                DateConfig.stringToLocalDate(user.getDateOfBirth().toString()),
                user.getMobileNumber().toString(),
                request.getPassword());
    }

    public static RegisterUserRequest dtoToRegisterUserRequestProto(RegistrationResponse response) {
        return RegisterUserRequest.newBuilder()
                .setUserId(response.getUserId())
                .setName(response.getName())
                .setEmail(response.getEmail())
                .setDob(DateConfig.localDateToString(response.getDateOfBirth()))
                .setMobileNumber(response.getMobileNumber())
                .setPassword(response.getPassword())
                .build();
    }

    public static OtpMessage forgotPasswordReqToOtpAvro(ForgotPasswordRequest request) {
        return OtpMessage.newBuilder().setEmail(request.getEmail())
                .setOtp(request.getOTP())
                .setFailedAttempts(request.getFailedOtpAttempts())
                .setPurpose(RESET_PASSWORD)
                .build();
    }

    public static PasswordRequest dtoToPasswordReqProto(ChangePasswordRequest request){
        return PasswordRequest.newBuilder()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword()).build();
    }
}
