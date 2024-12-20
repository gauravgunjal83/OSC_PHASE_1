package com.in.service.serviceImpl;

import com.in.avro.OtpMessage;
import com.in.dto.CustomStatusCodes;
import com.in.dto.ForgotPasswordRequest;
import com.in.dto.ResponseCode;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.service.ValidateOtpForForgotPasswordService;
import io.grpc.ManagedChannel;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class ValidateOtpForgotPasswordServiceImpl implements ValidateOtpForForgotPasswordService {
    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForgotPasswordServiceImpl.class);
    private final ManagedChannel managedChannel;
    private final ReadOnlyKeyValueStore<String, OtpMessage> otpStore;
    private final OtpKafkaProducer otpKafkaProducer;

    public ValidateOtpForgotPasswordServiceImpl(ManagedChannel managedChannel, ReadOnlyKeyValueStore<String, OtpMessage> otpStore, OtpKafkaProducer otpKafkaProducer) {
        this.managedChannel = managedChannel;
        this.otpStore = otpStore;
        this.otpKafkaProducer = otpKafkaProducer;
    }

    @Override
    public ResponseCode validateOtpToResetPassword(ForgotPasswordRequest request) {
        try {
            OtpMessage otpData = otpStore.get(request.getEmail());
            if (!otpData.getOtp().toString().equals(request.getOTP())) {
                int failedAttempts = otpData.getFailedAttempts() + 1;
                otpData.setFailedAttempts(failedAttempts);
                updateFailedOtpAttempts(request.getEmail(), otpData);
                log.error("OTP {} for Otp Validation", request.getOTP());
                return new ResponseCode(CustomStatusCodes.OTP_INVALID);
            }
            otpKafkaProducer.deleteOtp(request.getEmail());
            return new ResponseCode(CustomStatusCodes.OTP_VALID);

        } catch (Exception e) {
            log.error("Error during OTP validation \nplease check the credentials:{}",request.getEmail());
            return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
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
