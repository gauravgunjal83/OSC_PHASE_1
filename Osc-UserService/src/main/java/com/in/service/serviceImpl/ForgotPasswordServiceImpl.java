package com.in.service.serviceImpl;

import com.in.config.UtilConfig;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.mapper.Mapper;
import com.in.proto.UniqueEmailResponse;
import com.in.proto.UserDataServiceGrpc;
import com.in.service.ForgotPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    private static final Logger log = LoggerFactory.getLogger(ForgotPasswordServiceImpl.class);

    private final UserDataServiceGrpc.UserDataServiceBlockingStub userStub;
    private final OtpKafkaProducer otpProducer;
    private final UtilConfig.OtpGenerator otpGenerator;

    public ForgotPasswordServiceImpl(UserDataServiceGrpc.UserDataServiceBlockingStub userStub, OtpKafkaProducer otpProducer, UtilConfig.OtpGenerator otpGenerator) {
        this.userStub = userStub;
        this.otpProducer = otpProducer;
        this.otpGenerator = otpGenerator;
    }

    @Override
    public DataResponse forgotPassword(String email) {
        try {
            //checking for email is exist in db or not
            UniqueEmailResponse isEmailPresent = userStub.isEmailPresent(Mapper.emailToRequest(email));
            boolean isExists = Mapper.responseToDto(isEmailPresent);
            if (!isExists) {
                log.info("Please provide the valid email for forgot password. \nEmail does not exists:" + email);
                return new DataResponse(CustomStatusCodes.EMAIL_INVALID, null);
            }
            //Otp generation for forgot password
            String otp = otpGenerator.generateOtp();
            log.info("Otp is generated OTP:{} email: {} ", otp, email);
            otpProducer.publishToOtpTopic(new ForgotPasswordRequest(email, otp, 0));
            return new DataResponse(CustomStatusCodes.EMAIL_VALID, null);
        } catch (Exception e) {
            log.error("Error while processing:", e);
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, null);
        }
    }
}