package com.in.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class UtilConfig {

    @Bean
    public UserIdGenerator userIdGenerator() {
        return new UserIdGenerator();
    }

    @Bean
    public OtpGenerator otpGenerator() {
        return new OtpGenerator();
    }

    public static class UserIdGenerator {
        public String generateUserId(String name) {
            return name.substring(0, 3) + String.format("%04d", new Random().nextInt(10000));
        }
    }

    public static class OtpGenerator {
        public String generateOtp() {
            return String.format("%06d", new Random().nextInt(1000000));
        }
    }
}
