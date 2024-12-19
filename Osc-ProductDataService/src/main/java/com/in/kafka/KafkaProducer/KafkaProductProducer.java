package com.in.kafka.KafkaProducer;

import com.in.avro.ProductDetails;
import com.in.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProductProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProductProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProductProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishProductDataToKafka(String productId, ProductDetails productData) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstants.PRODUCT_TOPIC, productId, productData);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message [ProductData :{}] offset:{} partitions: {}", productData, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            } else
                log.error("Error:{}", ex.getMessage());
        });

    }
}
