package com.in.kafka.producer;

import com.in.avro.SessionKey;
import com.in.avro.SessionValue;
import com.in.config.AppConstants;
import com.in.dto.SessionRequestDto;
import com.in.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class SessionKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(SessionKafkaProducer.class);
    private final KafkaTemplate<SessionKey, SessionValue> kafkaTemplate;

    public SessionKafkaProducer(KafkaTemplate<SessionKey, SessionValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SessionKey sessionId, SessionValue sessionValue) {
        CompletableFuture<SendResult<SessionKey, SessionValue>> future = kafkaTemplate.send(AppConstants.SESSION_TOPIC, sessionId, sessionValue);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message [SessionValue :" + sessionValue + "] offset:" + result.getRecordMetadata().offset()
                        + " partitions: " + result.getRecordMetadata().partition());
            } else {
                log.error("Error:" + ex.getMessage());
            }
        });


    }

    public void publishToSessionTopic(SessionRequestDto sessionRequestDto) {
        try {
            send(sessionRequestDto.getSessionId(), Mapper.sessionReqDtoToAvro(sessionRequestDto));
            log.info("Session data is sent to topic:{}", sessionRequestDto);
        } catch (Exception e) {
            log.error("Error occurs in submitting data to session-topic", e);
        }
    }
}
