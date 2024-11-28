package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.LogoutRequestDto;

public interface LogoutRequestService {

    public DataResponse logoutUser(LogoutRequestDto logoutRequest);
}
