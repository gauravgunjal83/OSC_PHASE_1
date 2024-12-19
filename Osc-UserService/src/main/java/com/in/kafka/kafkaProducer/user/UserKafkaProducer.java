package com.in.kafka.kafkaProducer.user;

import com.in.avro.User;
import com.in.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class UserKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(UserKafkaProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public UserKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String userId, User user) {
        kafkaTemplate.send(AppConstant.USER_REGISTRATION_TOPIC, userId, user)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Sent message [user : {}] offset : {} partitions : {}", user, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
                    } else {
                        log.error("Error:{}", ex.getMessage());
                    }
                });
    }

    public void deleteUserDetails(String userId) {
        kafkaTemplate.send(AppConstant.USER_REGISTRATION_TOPIC, userId, null);
    }
}
