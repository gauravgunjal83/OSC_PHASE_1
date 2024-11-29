package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;

public interface ForgotPasswordService {

    public ResponseCode forgotPassword(String email);
}
