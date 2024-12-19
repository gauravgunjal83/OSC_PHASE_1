package com.in.config;

import com.in.kafka.KafkaProducer.KafkaCategoryProducer;
import com.in.kafka.KafkaProducer.KafkaProductCountProducer;
import com.in.kafka.KafkaProducer.KafkaProductProducer;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(AppConstants.PRODUCT_TOPIC, 12, (short) 1);
    }

    @Bean
    public NewTopic createTopic1() {
        return new NewTopic(AppConstants.CATEGORY_TOPIC, 3, (short) 1);
    }

    @Bean
    public NewTopic createTopic2() {
        return new NewTopic(AppConstants.PRODUCT_VIEWCOUNT_TOPIC, 7, (short) 1);
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOSTRAP_SERVER);
        return new KafkaAdmin(configs);
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOSTRAP_SERVER);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name="productProducer")
    public KafkaProductProducer productProducer() {
        return new KafkaProductProducer(kafkaTemplate());
    }

    @Bean(name = "categoryProducer")
    public KafkaCategoryProducer categoryProducer() {
        return new KafkaCategoryProducer(kafkaTemplate());
    }

    @Bean(name = "productViewCountProducer")
    public KafkaProductCountProducer productViewCountProducer() {
        return new KafkaProductCountProducer(kafkaTemplate());
    }
}
