package com.in.kafka.kafkaProducer.otp;

import com.in.avro.OtpMessage;
import com.in.config.AppConstant;
import com.in.dto.ForgotPasswordRequest;
import com.in.dto.OtpVerificationRequest;
import com.in.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OtpKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(OtpKafkaProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OtpKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String key, OtpMessage otpMessage) {
        kafkaTemplate.send(AppConstant.OTP_TOPIC, key, otpMessage)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Sent message [otp : {}] offset: {} partitions: {}", otpMessage, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
                    } else {
                        log.error("Error: {}", ex.getMessage());
                    }
                });
    }

    public boolean otpVerificationReqToDto(OtpVerificationRequest request) {
        try {
            send(request.getUserId(), Mapper.requestToOtp(request));
            log.info("Otp is send to topic for user registration: {}", request);
            return true;
        } catch (Exception e) {
            log.error("Error to sending otp to topic : ", e);
            return false;
        }
    }

    public void deleteOtp(String userId) {
        kafkaTemplate.send(AppConstant.OTP_TOPIC, userId, null);
    }

    public boolean otpVerificationReqToDto(ForgotPasswordRequest request) {
        try {
            send(request.getEmail(), Mapper.forgotPasswordReqToOtpAvro(request));
            log.info("Otp sent to otp topic for reset password for user {}", request);
            return true;
        } catch (Exception e) {
            log.error("Error while submitting otp in otp-topic", e);
            return false;

        }

    }
}

