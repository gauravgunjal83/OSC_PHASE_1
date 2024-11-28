package com.in.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class UtilConfig {

    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new SessionIdGenerator();
    }

    public static class SessionIdGenerator {
        public String generateSessionId() {
            return String.format("%06d", new Random().nextInt(100000));
        }
    }
}
