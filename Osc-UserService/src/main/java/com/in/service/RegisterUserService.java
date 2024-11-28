package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.RegistrationRequest;

public interface RegisterUserService {

    public DataResponse registerUser(RegistrationRequest request);
}
