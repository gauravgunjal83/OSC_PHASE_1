package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.RegistrationRequestDto;

public interface SignupUserService {

    public DataResponse signupUser(RegistrationRequestDto request);
}
