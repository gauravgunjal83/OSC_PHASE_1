package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.OtpValidateDtoRequest;
import com.in.dto.ResponseCode;

public interface ValidateOtpForSetPasswordService {

    public ResponseCode validateOtpForSetPassword(OtpValidateDtoRequest request);
}
