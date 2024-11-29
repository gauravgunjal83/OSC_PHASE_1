package com.in.service;

import com.in.dto.ChangePasswordRequest;
import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;

public interface ChangePasswordRequestService {

    public ResponseCode changePassword(ChangePasswordRequest passwordRequest);
}
