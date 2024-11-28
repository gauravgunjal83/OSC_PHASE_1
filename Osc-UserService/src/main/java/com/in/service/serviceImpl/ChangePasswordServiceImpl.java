package com.in.service.serviceImpl;

import com.in.dto.ChangePasswordRequest;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.mapper.Mapper;
import com.in.proto.PasswordResponse;
import com.in.proto.UniqueEmailResponse;
import com.in.proto.UserDataServiceGrpc;
import com.in.service.ChangePasswordRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordRequestService {
    private static final Logger log = LoggerFactory.getLogger(ChangePasswordServiceImpl.class);

    private final UserDataServiceGrpc.UserDataServiceBlockingStub userDataServiceBlockingStub;

    public ChangePasswordServiceImpl(UserDataServiceGrpc.UserDataServiceBlockingStub userDataServiceBlockingStub) {
        this.userDataServiceBlockingStub = userDataServiceBlockingStub;
    }

    @Override
    public DataResponse changePassword(ChangePasswordRequest request) {
        UniqueEmailResponse isEmailPresent = userDataServiceBlockingStub.isEmailPresent(Mapper.emailToRequest(request.getEmail()));
        boolean isExists = Mapper.responseToDto(isEmailPresent);
        if (!isExists){
            log.info("Email is not found :{}",request.getEmail());
            return new DataResponse(CustomStatusCodes.PASSWORD_NOT_SAVED,null);
        }
        PasswordResponse response = userDataServiceBlockingStub.resetPassword(Mapper.dtoToPasswordReqProto(request));
        return new DataResponse(CustomStatusCodes.PASSWORD_SAVED, response.getMessage());
    }
}
