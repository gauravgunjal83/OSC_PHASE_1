package com.in.service;

import com.in.dto.CreateSessionDto;
import com.in.dto.SessionResponseDto;

public interface LoginRequestService {
    public SessionResponseDto createSession(CreateSessionDto sessionDto);
}
