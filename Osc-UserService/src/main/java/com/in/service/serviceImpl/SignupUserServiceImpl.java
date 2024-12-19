package com.in.service.serviceImpl;

import com.in.config.UtilConfig.OtpGenerator;
import com.in.config.UtilConfig.UserIdGenerator;
import com.in.dto.CustomStatusCodes;
import com.in.dto.DataResponse;
import com.in.dto.OtpVerificationRequest;
import com.in.dto.RegistrationRequestDto;
import com.in.kafka.kafkaProducer.otp.OtpKafkaProducer;
import com.in.kafka.kafkaProducer.user.UserKafkaProducer;
import com.in.mapper.Mapper;
import com.in.proto.UniqueEmailResponse;
import com.in.proto.UserDataServiceGrpc;
import com.in.service.SignupUserService;
import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SignupUserServiceImpl implements SignupUserService {

    private static final int OTP_INITIAL_FAILED_ATTEMPT_COUNT = 0;
    private static final Logger log = LoggerFactory.getLogger(SignupUserServiceImpl.class);
    private final UserIdGenerator userIdGenerator;
    private final OtpGenerator otpGenerator;
    private final UserKafkaProducer userKafkaProducer;
    private final OtpKafkaProducer otpKafkaProducer;
    private final ManagedChannel manageChannel;
    private final UserDataServiceGrpc.UserDataServiceBlockingStub stub;

    public SignupUserServiceImpl(UserIdGenerator userIdGenerator, OtpGenerator otpGenerator, UserKafkaProducer userKafkaProducer, OtpKafkaProducer otpKafkaProducer, ManagedChannel manageChannel, UserDataServiceGrpc.UserDataServiceBlockingStub stub) {
        this.userIdGenerator = userIdGenerator;
        this.otpGenerator = otpGenerator;
        this.userKafkaProducer = userKafkaProducer;
        this.otpKafkaProducer = otpKafkaProducer;
        this.manageChannel = manageChannel;
        this.stub = stub;
    }


    @Override
    public DataResponse signupUser(RegistrationRequestDto request) {
        if (!checkUniqueEmail(request.getEmail())) {
            log.error("Email '{}' is already registered", request.getEmail());
            return new DataResponse(CustomStatusCodes.EMAIL_EXISTS, null);
        }
        try {
            String userId = userIdGenerator.generateUserId(request.getName());
            String otp = otpGenerator.generateOtp();
            log.info("Generated UserId: {}, OTP: {}", userId, otp);
            userKafkaProducer.send(userId, Mapper.registrationReqDtoToUserAvro(request));
            boolean isEmailSend = otpKafkaProducer.otpVerificationReqToDto(new OtpVerificationRequest(userId, otp, request.getEmail(), OTP_INITIAL_FAILED_ATTEMPT_COUNT));

            if (!isEmailSend) {
                log.error("Failed to send OTP for UserId: {}", userId);
                return new DataResponse(CustomStatusCodes.USER_CREATION_FAILED, null);
            }
            log.info("User registration successful for UserId: {}", userId);
            return new DataResponse(CustomStatusCodes.USER_CREATION_SUCCESS, Map.of("userId", userId));
        } catch (Exception e) {
            log.error("Error during user registration:", e);
            return new DataResponse(CustomStatusCodes.UNEXPECTED_ERROR, null);
        }

    }
    public boolean checkUniqueEmail(String email) {
        log.info("Checking for is Email address unique : {}", email);
        UniqueEmailResponse verifyEmailAddressIsUnique = stub.verifyEmailAddressIsUnique(Mapper.emailToUniqueEmailReqProto(email));
        boolean emailExists = Mapper.uniqueEmailResponseProtoToDto(verifyEmailAddressIsUnique);
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
                Thread.currentThread().interrupt();
            }
        }
    }

}
