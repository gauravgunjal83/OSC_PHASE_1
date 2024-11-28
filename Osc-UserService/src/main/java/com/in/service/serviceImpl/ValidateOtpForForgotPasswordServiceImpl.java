package com.in.service.serviceImpl;

import com.in.avro.OtpMessage;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.service.ValidateOtpForForgotPasswordService;
import io.grpc.ManagedChannel;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class ValidateOtpForForgotPasswordServiceImpl implements ValidateOtpForForgotPasswordService {
    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForForgotPasswordServiceImpl.class);
    private final ManagedChannel managedChannel;
    private final ReadOnlyKeyValueStore<String, OtpMessage> otpStore;
    private final OtpKafkaProducer otpKafkaProducer;

    public ValidateOtpForForgotPasswordServiceImpl(ManagedChannel managedChannel, ReadOnlyKeyValueStore<String, OtpMessage> otpStore, OtpKafkaProducer otpKafkaProducer) {
        this.managedChannel = managedChannel;
        this.otpStore = otpStore;
        this.otpKafkaProducer = otpKafkaProducer;
    }

    @Override
    public DataResponse validateOtpToResetPassword(ForgotPasswordRequest request) {
        try {
            OtpMessage otpData = otpStore.get(request.getEmail());
            if (!otpData.getOtp().toString().equals(request.getOTP())) {
                int failedAttempts = otpData.getFailedAttempts() + 1; // increase failedAttempts
                otpData.setFailedAttempts(failedAttempts);
                updateFailedOtpAttempts(request.getEmail(), otpData);
                log.error("OTP {} for Otp Validation", request.getOTP());
                return new DataResponse(CustomStatusCodes.OTP_INVALID, "Invalid OTP");
            }
            otpKafkaProducer.deleteOtp(request.getEmail());  //delete data from user-topic
            return new DataResponse(CustomStatusCodes.OTP_VALID, "OTP Validated Successfully");

        } catch (Exception e) {
            log.error("Error during OTP validation \nplease check the credentials:{}",request.getEmail());
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, "Internal Server Error");
        }
    }

    private void updateFailedOtpAttempts(String email, OtpMessage otpData) {
        if (otpData != null) {
            OtpMessage updatedOtpMessage = OtpMessage.newBuilder(otpData)
                    .setFailedAttempts(otpData.getFailedAttempts()).build();
            otpKafkaProducer.send(email, updatedOtpMessage);
        } else {
            log.error("No OTP record found for Email: " + email);
        }
    }

    @PreDestroy
    public void shutdown() {
        if (managedChannel != null && !managedChannel.isShutdown()) {
            managedChannel.shutdown();
            try {
                if (!managedChannel.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    managedChannel.shutdownNow();
                }
            } catch (InterruptedException e) {
                managedChannel.shutdownNow();
            }
        }
    }
}
