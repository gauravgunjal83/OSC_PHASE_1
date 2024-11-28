package com.in.mapper;

import com.in.Session.CreateSessionRequest;
import com.in.Session.SessionStatusResponse;
import com.in.Session.ValidateSessionRequest;
import com.in.avro.SessionValue;
import com.in.dto.LoginRequestDto;
import com.in.dto.LogoutRequestDto;
import com.in.dto.SessionRequestDto;
import com.in.proto.VerifyCredentialsRequest;

public class Mapper {

    public static SessionValue sessionReqDtoToAvro(SessionRequestDto sessionRequestDto) {
        return new SessionValue(sessionRequestDto.isActive());
    }

    public static VerifyCredentialsRequest loginReqDtoToProto(LoginRequestDto loginRequestDto) {
        return VerifyCredentialsRequest.newBuilder().setUserId(loginRequestDto.getUserId()).build();
    }

    public static CreateSessionRequest requestToCreateSessionResponse(String sessionId, String userId, String deviceName) {
        return CreateSessionRequest.newBuilder()
                .setUserId(userId)
                .setDeviceType(deviceName)
                .setSessionId(sessionId).build();
    }

    public static ValidateSessionRequest logoutReqDtoToValidateSessionReqProto(LogoutRequestDto logoutRequest) {
        return ValidateSessionRequest.newBuilder().setSessionId(logoutRequest.getSessionId())
                .setUserId(logoutRequest.getUserId()).build();
    }

    public static boolean sessionStatusResponseProtoToDto(SessionStatusResponse response) {
        return response.getIsActive();
    }
}
