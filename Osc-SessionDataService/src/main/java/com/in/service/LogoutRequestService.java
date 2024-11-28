package com.in.service;

import com.in.dto.LogoutRequestDto;
import com.in.dto.LogoutResponseDto;

public interface LogoutRequestService {

    public LogoutResponseDto logoutUser(LogoutRequestDto logoutRequest);
}
