package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;
import com.in.dto.ResponseCode;

public interface ValidateOtpForForgotPasswordService {
    public ResponseCode validateOtpToResetPassword(ForgotPasswordRequest request);
}
