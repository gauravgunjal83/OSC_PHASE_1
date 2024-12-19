package com.in.kafka.KafkaProducer;

import com.in.avro.CategoryDetails;
import com.in.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaCategoryProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaCategoryProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaCategoryProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishCategoryDataToKafka(String categoryId, CategoryDetails categoryData) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstants.CATEGORY_TOPIC, categoryId, categoryData);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message [CategoryData :{}] offset:{} partitions: {}", categoryData, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            } else
                log.error("Error:{}", ex.getMessage());
        });

    }
}
