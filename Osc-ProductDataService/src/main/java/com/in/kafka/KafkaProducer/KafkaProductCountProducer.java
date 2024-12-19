package com.in.kafka.KafkaProducer;

import com.in.avro.ProductViewCount;
import com.in.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProductCountProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProductCountProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProductCountProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishProductViewCountToKafka(String productId, ProductViewCount productViewCountData) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstants.PRODUCT_VIEWCOUNT_TOPIC, productId, productViewCountData);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message [productViewCountData :{}] offset:{} partitions: {}", productViewCountData, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            } else {
                log.error("Error:{}", ex.getMessage());
            }
        });
    }
}
