package com.in.service;

import com.in.dto.ChangePasswordRequest;
import com.in.dto.DataResponse;

public interface ChangePasswordRequestService {

    public DataResponse changePassword(ChangePasswordRequest passwordRequest);
}
