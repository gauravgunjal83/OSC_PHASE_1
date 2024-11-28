package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;

public interface ValidateOtpForForgotPasswordService {
    public DataResponse validateOtpToResetPassword(ForgotPasswordRequest request);
}
