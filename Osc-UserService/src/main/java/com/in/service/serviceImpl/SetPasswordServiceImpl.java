package com.in.service.serviceImpl;

import com.in.avro.User;
import com.in.dto.*;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.kafka.kafkaProducer.user.UserKafkaProducer;
import com.in.mapper.Mapper;
import com.in.proto.RegisterUserRequest;
import com.in.proto.UserDataServiceGrpc;
import com.in.service.SetPasswordService;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SetPasswordServiceImpl implements SetPasswordService {
    private static final Logger log = LoggerFactory.getLogger(SetPasswordServiceImpl.class);

    private final UserDataServiceGrpc.UserDataServiceBlockingStub stub;
    private final OtpKafkaProducer otpKafkaProducer;
    private final UserKafkaProducer userKafkaProducer;
    private final ReadOnlyKeyValueStore<String, User> userKeyValueStore;

    public SetPasswordServiceImpl(UserDataServiceGrpc.UserDataServiceBlockingStub stub, OtpKafkaProducer otpKafkaProducer, UserKafkaProducer userKafkaProducer, ReadOnlyKeyValueStore<String, User> userKeyValueStore) {
        this.stub = stub;
        this.otpKafkaProducer = otpKafkaProducer;
        this.userKafkaProducer = userKafkaProducer;
        this.userKeyValueStore = userKeyValueStore;
    }

    @Override
    public ResponseCode setUserPassword(SetPasswordRequest request) {
        User user = userKeyValueStore.get(request.getUserId());
        if (user == null) {
            log.error("User not found with this Id: {}", request.getUserId());
            return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
        }
        try {
            RegistrationResponse registrationResponse = Mapper.dtoToRegistrationResponseDto(request.getUserId(), user, request);
            RegisterUserRequest userRequest = Mapper.dtoToRegisterUserRequestProto(registrationResponse);
            stub.registerUser(userRequest);
            log.info("User registration is completed successfully: {}", user);
            otpKafkaProducer.deleteOtp(request.getUserId());
            userKafkaProducer.deleteUserDetails(request.getUserId());
            return new ResponseCode(CustomStatusCodes.USER_CREATION_SUCCESS);
        } catch (Exception ex) {
            log.error("Error while setting up the password for the user id: {}", request.getUserId(), ex);
            return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
        }
    }
}
