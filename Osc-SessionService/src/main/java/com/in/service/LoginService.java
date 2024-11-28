package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.LoginRequestDto;

public interface LoginService {

    public DataResponse loginRequest(LoginRequestDto loginRequest);
}
