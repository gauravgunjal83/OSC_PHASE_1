package com.in.service;

import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;
import com.in.dto.SetPasswordRequest;

public interface SetPasswordService {

    public ResponseCode setUserPassword(SetPasswordRequest request);
}
