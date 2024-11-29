package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.LogoutRequestDto;
import com.in.dto.ResponseCode;

public interface LogoutRequestService {

    public ResponseCode logoutUser(LogoutRequestDto logoutRequest);
}
