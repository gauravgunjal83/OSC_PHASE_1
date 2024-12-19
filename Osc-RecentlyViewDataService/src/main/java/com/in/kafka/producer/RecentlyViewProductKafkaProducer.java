package com.in.kafka.producer;

import com.in.avro.RecentViewProduct;
import com.in.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class RecentlyViewProductKafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(RecentlyViewProductKafkaProducer.class);

    private final KafkaTemplate<String, RecentViewProduct> kafkaTemplate;

    public RecentlyViewProductKafkaProducer(KafkaTemplate<String, RecentViewProduct> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToRecentlyViewProductTopic(String userId, RecentViewProduct recentViewProduct) {
        CompletableFuture<SendResult<String, RecentViewProduct>> future = kafkaTemplate.send(AppConstants.RECENTLY_VIEW_PRODUCT_TOPIC, userId, recentViewProduct);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message [RecentlyViewProduct :{}] offset:{} partitions: {}", recentViewProduct, result.getRecordMetadata().offset(), result.getRecordMetadata().partition());
            } else
                log.error("Error:{}", ex.getMessage());
        });
    }
}
