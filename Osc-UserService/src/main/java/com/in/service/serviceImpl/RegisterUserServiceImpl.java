package com.in.service.serviceImpl;

import com.in.config.UtilConfig.OtpGenerator;
import com.in.config.UtilConfig.UserIdGenerator;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.OtpVerificationRequest;
import com.in.dto.RegistrationRequest;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.kafka.kafkaProducer.user.UserKafkaProducer;
import com.in.mapper.Mapper;
import com.in.proto.UniqueEmailResponse;
import com.in.proto.UserDataServiceGrpc;
import com.in.service.RegisterUserService;
import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    private static final Logger log = LoggerFactory.getLogger(RegisterUserServiceImpl.class);
    private final UserIdGenerator userIdGenerator;
    private final OtpGenerator otpGenerator;
    private final UserKafkaProducer userKafkaProducer;
    private final OtpKafkaProducer otpKafkaProducer;
    private final ManagedChannel manageChannel;
    private final UserDataServiceGrpc.UserDataServiceBlockingStub stub;

    public RegisterUserServiceImpl(UserIdGenerator userIdGenerator, OtpGenerator otpGenerator, UserKafkaProducer userKafkaProducer, OtpKafkaProducer otpKafkaProducer, ManagedChannel manageChannel, UserDataServiceGrpc.UserDataServiceBlockingStub stub) {
        this.userIdGenerator = userIdGenerator;
        this.otpGenerator = otpGenerator;
        this.userKafkaProducer = userKafkaProducer;
        this.otpKafkaProducer = otpKafkaProducer;
        this.manageChannel = manageChannel;
        this.stub = stub;
    }


    @Override
    public DataResponse registerUser(RegistrationRequest request) {
        // Start by validating the email

        if (!checkUniqueEmail(request.getEmail())) {
            log.error("Email '{}' is already registered", request.getEmail());
            return new DataResponse(CustomStatusCodes.EMAIL_EXISTS, null);
        }
        try {
            //Generate UserId and Otp
            String userId = userIdGenerator.generateUserId(request.getName());
            String otp = otpGenerator.generateOtp();
            log.info("Generated UserId: {}, OTP: {}", userId, otp);

            //publish user details to kafka topic
            userKafkaProducer.send(userId, Mapper.requestToUser(request));

            //Produce OTP data in to OTP topic
            boolean isEmailSend = otpKafkaProducer.publishToOtpTopic(new OtpVerificationRequest(userId, otp, request.getEmail(), 0));

            if (!isEmailSend) {
                log.error("Failed to send OTP for UserId: {}", userId);
                return new DataResponse(CustomStatusCodes.USER_CREATION_FAILED, null); //otp failure
            }

            //Return success response with the generated userId
            log.info("User registration successful for UserId: {}", userId);
            return new DataResponse(CustomStatusCodes.USER_CREATION_SUCCESS, Map.of("userId", userId));
        } catch (Exception e) {
            log.error("Error during user registration:", e);
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, null);
        }

    }

    //Check is email unique
    public boolean checkUniqueEmail(String email) {
        log.info("Checking for is Email address unique : {}", email);
        UniqueEmailResponse verifyEmailAddressIsUnique = stub.verifyEmailAddressIsUnique(Mapper.emailToRequest(email));
        boolean emailExists = Mapper.responseToDto(verifyEmailAddressIsUnique);
        return emailExists;
    }

    public void shutdown() {
        if (manageChannel != null && !manageChannel.isShutdown()) {
            try {
                manageChannel.shutdown();
                if (!manageChannel.awaitTermination(5, TimeUnit.SECONDS)) {
                    log.warn("Channel did not terminate within the timeout. Forcing shutdown...");
                    manageChannel.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("Shutdown interrupted. Forcing immediate shutdown...", e);
                manageChannel.shutdownNow();
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        }
    }

}
