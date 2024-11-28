package com.in.mapper;

import com.in.config.AppConfig;
import com.in.dto.ChangePasswordDto;
import com.in.dto.UserLoginDto;
import com.in.dto.UserRegistrationRequestDto;
import com.in.proto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mapper {

    private static final Logger log = LoggerFactory.getLogger(Mapper.class);

    public static UserRegistrationRequestDto requestToDto(RegisterUserRequest request) {
        if (request == null) {
            log.error("Register user request is null");
            throw new IllegalArgumentException("Request can not be null");
        }
        return new UserRegistrationRequestDto(
                request.getUserId(),
                request.getName(),
                request.getEmail(),
                AppConfig.stringToLocalDate(request.getDob()),
                request.getMobileNumber(),
                request.getPassword()
        );
    }

    public static RegisterUserResponse dtoToResponse(UserRegistrationRequestDto userDto) {
        if (userDto == null) {
            log.error("UserRequestDto is null");
            throw new IllegalArgumentException("User DTO cannot be null");
        }
        return RegisterUserResponse.newBuilder().setSuccess(true).setMessage(userDto.getUserId()).build();
    }

    public static String requestToDto(UniqueEmailRequest request) {
        if (request == null) {
            log.error("UniqueEmailRequest is null");
            throw new IllegalArgumentException("Request cannot be null");
        }
        return request.getEmail();
    }

    public static UniqueEmailResponse dtoToResponse(boolean isUnique) {
        return UniqueEmailResponse.newBuilder().setIsUnique(isUnique).build();
    }

    public static VerifyCredentialsResponse dtoToVerifyCredentialsResponse(UserLoginDto userLoginDto) {
        return VerifyCredentialsResponse.newBuilder().setUserId(userLoginDto.getUserId())
                .setName(userLoginDto.getName())
                .setPassword(userLoginDto.getPassword()).build();
    }

    public static String uniqueEmailReqProtoToDto(UniqueEmailRequest request) {
        if (request == null) {
            log.error("Email request is null");
            throw new IllegalArgumentException("Request cannot be null");
        }
        return request.getEmail();
    }

    public static ChangePasswordDto passwordReqProtoToChangePasswordDto(PasswordRequest request){
        return new ChangePasswordDto(request.getEmail(),
                request.getPassword());
    }

    public static PasswordResponse booleanToPasswordResponseProto(boolean isUpdate){
        return PasswordResponse.newBuilder().setMessage(isUpdate ? "Password updated successfully" : "Password updation failed").build();
    }
}
