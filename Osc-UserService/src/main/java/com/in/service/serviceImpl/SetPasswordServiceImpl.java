package com.in.service.serviceImpl;

import com.in.avro.User;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.RegistrationResponse;
import com.in.dto.SetPasswordRequest;
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
    public DataResponse setUserPassword(SetPasswordRequest request) {
        //Retrieve user data from the kafka state store
        User user = userKeyValueStore.get(request.getUserId());
        if (user == null) {
            log.error("User not found with this Id: {}", request.getUserId());
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "User not found.");
        }
        try {
            //Convert Dtos to registrationResponse and gRPC request
            RegistrationResponse registrationResponse = Mapper.dtoToRegistrationResponseDto(request.getUserId(), user, request);
            RegisterUserRequest userRequest = Mapper.dtoToRegisterUserRequestProto(registrationResponse);

            //Call the gRPC service to register the user
            stub.registerUser(userRequest);
            log.info("User registration is completed successfully: {}", user);

            // Clean up kafka topics(delete otp and user data)
            otpKafkaProducer.deleteOtp(request.getUserId());
            userKafkaProducer.deleteUserDetails(request.getUserId());
            return new DataResponse(CustomStatusCodes.OTP_VALID, "User registered successfully");
        } catch (Exception ex) {
            log.error("Error while setting up the password for the user id: {}", request.getUserId(), ex);
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "Failed to setting password.");
        }
    /*    User user = userKeyValueStore.get(request.getUserId());
        if (user == null) {
            log.error("user not found for ID: {}", request.getUserId());
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "User not found..! Password not set.");
        }
        try {
            RegistrationResponse response = Mapper.dtoToRegistrationResponseDto(request.getUserId(),user, request);
            stub.registerUser(Mapper.dtoToRegisterUserRequestProto(response));
            log.info("user registration completed !! "+user.toString());
            otpKafkaProducer.deleteOtp(request.getUserId());
            userKafkaProducer.deleteUserDetails(request.getUserId());
            return new DataResponse(CustomStatusCodes.OTP_VALID, response);
        } catch (Exception e) {
            log.error("Error while setting password for user ID: {}", request.getUserId(), e);
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "Failed to set password.");
        }*/
    }
}
