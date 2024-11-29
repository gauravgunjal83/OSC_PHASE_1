package com.in.service.serviceImpl;

import com.in.avro.OtpMessage;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.OtpValidateDtoRequest;
import com.in.dto.ResponseCode;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.kafka.kafkaProducer.user.UserKafkaProducer;
import com.in.service.ValidateOtpForSetPasswordService;
import io.grpc.ManagedChannel;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class ValidateOtpForSetPasswordServiceImpl implements ValidateOtpForSetPasswordService {

    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForSetPasswordServiceImpl.class);
    private final ManagedChannel channel;
    private final UserKafkaProducer userKafkaProducer;
    private final OtpKafkaProducer otpKafkaProducer;
    private final ReadOnlyKeyValueStore<String, OtpMessage> otpStore;

    public ValidateOtpForSetPasswordServiceImpl(ManagedChannel channel, UserKafkaProducer userKafkaProducer, OtpKafkaProducer otpKafkaProducer, ReadOnlyKeyValueStore<String, OtpMessage> otpStore) {
        this.channel = channel;
        this.userKafkaProducer = userKafkaProducer;
        this.otpKafkaProducer = otpKafkaProducer;
        this.otpStore = otpStore;
    }

    @Override
    public ResponseCode validateOtpForSetPassword(OtpValidateDtoRequest request) {
       /* OtpMessage message = otpStore.get(request.getUserId());
        if (message == null) {
            log.error("UserId {} not found for validation", request.getUserId());
            return new DataResponse(CustomStatusCodes.OTP_VALIDATED, "OTP Validated Successfully");
        }
        if (!message.getOtp().toString().equals(request.getOTP())) {
            int failedAttempts = message.getFailedAttempts() + 1;
            updateFailedOtpAttempts(request.getUserId(), failedAttempts, message);

            if (failedAttempts > 3) {
                handleMaxFailedAttempts(request.getUserId());
                return new DataResponse(CustomStatusCodes.MAX_FAILED_ATTEMPT, "Maximum OTP attempts reached. Redirecting to registration.");
            }
            log.error("Invalid OTP provided for userId: {}", request.getUserId());
            return new DataResponse(CustomStatusCodes.INCORRECT_OTP, "Invalid OTP");
        }
        log.info("OTP successfully validated for userId: {}", request.getUserId());
        otpKafkaProducer.deleteOtp(request.getUserId());
        return new DataResponse(CustomStatusCodes.OTP_VALIDATED, "OTP Validated Successfully");
    }

    private void handleMaxFailedAttempts(String userId) {
        log.warn("Maximum failed OTP attempts reached for userId: {}. Deleting user and OTP data.", userId);
        userKafkaProducer.deleteUserDetails(userId);
        otpKafkaProducer.deleteOtp(userId);
    }

    private void updateFailedOtpAttempts(String userId, int failedAttempts, OtpMessage message) {
        log.info("Updating failed OTP attempts for userId: {}. Current attempts: {}", userId, failedAttempts);
        OtpMessage updatedOtpMessage = OtpMessage.newBuilder(message).setFailedAttempts(failedAttempts).build();
        otpKafkaProducer.send(userId, updatedOtpMessage);
    }

    public void shutdown() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
            try {
                if (!channel.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    channel.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("Error during channel shutdown: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
                channel.shutdownNow();
            }
        }
    }*/
        try {
            OtpMessage otpData = otpStore.get(request.getUserId());

            if (otpData == null) {
                log.error("userId {} for Otp Validation not Match ", request.getUserId());
                return new ResponseCode(CustomStatusCodes.USER_ID_NOT_FOUND);
            }
            if (!otpData.getOtp().toString().equals(request.getOTP())) {

                int failedAttempts = otpData.getFailedAttempts() + 1; // increase failedAttempts
                otpData.setFailedAttempts(failedAttempts);
                updateFailedOtpAttempts(request.getUserId(), otpData);
                log.error("OTP {} for Otp Validation", request.getOTP());

                if (failedAttempts > 3) {
                    userKafkaProducer.deleteUserDetails(request.getUserId());  //delete data from user-topic
                    otpKafkaProducer.deleteOtp(request.getUserId());
                    return new ResponseCode(CustomStatusCodes.MAX_FAILED_ATTEMPT);
                }
                return new ResponseCode(CustomStatusCodes.INCORRECT_OTP);
            }

            return new ResponseCode(CustomStatusCodes.OTP_VALIDATED);

        } catch (Exception e) {
            log.error("Error during OTP validation", e);
            return new ResponseCode(CustomStatusCodes.UNEXPECTED_ERROR);
        }
    }

    private void updateFailedOtpAttempts(String userId, OtpMessage otpData) {
        if (otpData != null) {
            OtpMessage updatedOtpMessage = OtpMessage.newBuilder(otpData)
                    .setFailedAttempts(otpData.getFailedAttempts()).build();
            otpKafkaProducer.send(userId,updatedOtpMessage);
        } else {
            log.error("No OTP record found for userId: " + userId);
        }
    }
    @PreDestroy
    public void shutdown() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
            try {
                if (!channel.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    channel.shutdownNow();
                }
            } catch (InterruptedException e) {
                channel.shutdownNow();
            }
        }
    }
}
