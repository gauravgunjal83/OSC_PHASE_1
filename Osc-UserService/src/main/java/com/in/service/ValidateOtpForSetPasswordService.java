package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.OtpValidateDtoRequest;

public interface ValidateOtpForSetPasswordService {

    public DataResponse validateOtpForSetPassword(OtpValidateDtoRequest request);
}
