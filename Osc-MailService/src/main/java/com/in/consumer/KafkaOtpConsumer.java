package com.in.consumer;

import com.in.avro.OtpMessage;
import com.in.kafka.config.AppConstants;
import com.in.service.EmailSenderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class KafkaOtpConsumer {

    private static Logger log = LoggerFactory.getLogger(KafkaOtpConsumer.class);

    private final EmailSenderService emailSenderService;

    public KafkaOtpConsumer(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @KafkaListener(topics = AppConstants.OTP_TOPIC, groupId = AppConstants.GROUP_ID)
    public void consumeOtp(ConsumerRecord<String, OtpMessage> record) {
        OtpMessage otpMessage = record.value();
        if (otpMessage == null) {
            log.error("Received null OtpMessage for key: {}", record.key());
            return; // Don't process further if the message is null
        }
        // Proceed only if otpMessage is not null
        try {
            String email = otpMessage.getEmail() != null ? otpMessage.getEmail().toString() : "Unknown Email";
            String purpose = otpMessage.getPurpose() != null ? otpMessage.getPurpose().toString() : "Unknown Purpose";
            int failedAttempts = otpMessage.getFailedAttempts();
            String otp = otpMessage.getOtp() != null ? otpMessage.getOtp().toString() : "Unknown OTP";
            String key = record.key();

            log.info("Processing OTP message: key = {}, email = {}, purpose = {}, failedAttempts = {}, otp = {}",
                    key, email, purpose, failedAttempts, otp);

            if (failedAttempts == 0) {
                switch (purpose) {
                    case "USER_REGISTRATION":
                        emailSenderService.sendRegistrationEmail(email, key, otp);
                        log.info("Registration email sent to: {}", email);
                        break;

                    case "RESET_PASSWORD":
                        emailSenderService.sendResetPasswordEmail(email, otp);
                        log.info("Reset password email sent to: {}", email);
                        break;

                    default:
                        log.warn("Unrecognized purpose: {}", purpose);
                }
            } else if (failedAttempts >= 3) {
                log.warn("Maximum OTP validation attempts exceeded for email: {}", email);
            } else {
                log.info("Conditions not met for sending email: email = {}, failedAttempts = {}", email, failedAttempts);
            }
        } catch (MessagingException e) {
            log.error("MessagingException while sending email: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error while processing OTP message: {}", e.getMessage(), e);
        }

        /*String email = otpMessage.getEmail().toString();
        String purpose = otpMessage.getPurpose().toString();
        int failedAttempts = otpMessage.getFailedAttempts();
        String otp = otpMessage.getOtp().toString();
        String key = record.key();

        try {
            log.info("Processing OTP message: key = {}, email = {}, purpose = {}, failedAttempts = {}, otp = {}",
                    key, email, purpose, failedAttempts, otp);

            if (failedAttempts == 0) {
                switch (purpose) {
                    case "USER_REGISTRATION":
                        emailSenderService.sendRegistrationEmail(email, key, otp);
                        log.info("Registration email sent to: {}", email);
                        break;

                    case "RESET_PASSWORD":
                        emailSenderService.sendResetPasswordEmail(email, otp);
                        log.info("Reset password email sent to: {}", email);
                        break;

                    default:
                        log.warn("Unrecognized purpose: {}", purpose);
                }
            } else if (failedAttempts >= 3) {
                log.warn("Maximum OTP validation attempts exceeded for email: {}", email);
            } else {
                log.info("Conditions not met for sending email: email = {}, failedAttempts = {}", email, failedAttempts);
            }
        } catch (MessagingException e) {
            log.error("MessagingException while sending email: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error while processing OTP message: {}", e.getMessage(), e);
        }*/
    }
}