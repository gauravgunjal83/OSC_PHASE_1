package com.in.mapper;

import com.in.Session.CreateSessionRequest;
import com.in.Session.CreateSessionResponse;
import com.in.Session.SessionStatusResponse;
import com.in.Session.ValidateSessionRequest;
import com.in.dto.CreateSessionDto;
import com.in.dto.LogoutRequestDto;
import com.in.dto.LogoutResponseDto;
import com.in.dto.SessionResponseDto;

import java.time.LocalDateTime;

public class Mapper {

    public static SessionResponseDto dtoToSessionResponseEntity(CreateSessionDto sessionDto) {
        return new SessionResponseDto(sessionDto.getSessionId(),
                sessionDto.getUserId(),
                sessionDto.getLoginDevice(),
                LocalDateTime.now(), null);
    }

    public static CreateSessionDto requestToCreateSessionDto(CreateSessionRequest request) {
        return new CreateSessionDto(request.getUserId(),
                request.getSessionId(),
                request.getDeviceType());
    }

    public static CreateSessionResponse dtoToCreateSessionResponseProto(SessionResponseDto responseDto) {
        boolean isActive = (responseDto.getLogoutTime() == null);
        return CreateSessionResponse.newBuilder().setSuccess(isActive).build();
    }

    public static LogoutRequestDto validateSessionReqProtoToLogoutReqDto(ValidateSessionRequest request){
        return  new LogoutRequestDto(request.getUserId(), request.getSessionId());
    }

    public static SessionStatusResponse logoutResponseDtoToSessionStatusResProto(LogoutResponseDto logoutResponse){
        return SessionStatusResponse.newBuilder().setUserId(logoutResponse.getUserId())
                .setDeviceType(logoutResponse.getSessionId())
                .setIsActive(logoutResponse.isLogout()).build();
    }
}
