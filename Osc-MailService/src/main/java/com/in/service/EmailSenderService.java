package com.in.service;

import com.in.consumer.KafkaOtpConsumer;
import com.in.kafka.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailSenderService {
    private static Logger log = LoggerFactory.getLogger(KafkaOtpConsumer.class);

    private Session createSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", AppConstants.SMTP_HOST);
        properties.put("mail.smtp.port", "587");
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AppConstants.USERNAME, AppConstants.PASSWORD);
            }
        });
    }

    private void sendEmail(String recipient, String subject, String body) throws MessagingException {
        Session session = createSession();
        session.setDebug(true); // see all log

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AppConstants.USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            log.info("Email sent successfully to {}.", recipient);
        } catch (MessagingException e) {
            log.error("Failed to send email to {}.", recipient, e);
            throw e;
        }
    }

    public void sendRegistrationEmail(String recipient, String uniqueId, String otp) throws MessagingException {
        String subject = "OroSoft Shopping Cart \nComplete your REGISTRATION";
        String body = String.format(
                "Welcome to OroSoft Shopping Cart \n Dear User,\nYour One-Time Password (OTP) for accessing OroSoft Shopping Application is: %s\nPlease use this code to complete your registration. \nYour shopping journey awaits! Experience the joy of secure and seamless shopping with Orosoft. \n\nThank you,\n" +
                        "OroSoft Shopping Team", otp, uniqueId);
        sendEmail(recipient, subject, body);
    }

    public void sendResetPasswordEmail(String recipient, String otp) throws MessagingException {
        String subject = "Your OTP Code for RESET_PASSWORD";
        String body = String.format("Welcome to OroSoft Shopping Cart \n Dear User,\n\nYour One-Time Password (OTP) for accessing OroSoft Shopping Application is: %s\n\nPlease use this code to reset your password. \n\nYour shopping journey awaits! Experience the joy of secure and seamless shopping with Orosoft. \n\nThank you,\n" +
                "OroSoft Shopping Team", otp);
        sendEmail(recipient, subject, body);
    }
}

