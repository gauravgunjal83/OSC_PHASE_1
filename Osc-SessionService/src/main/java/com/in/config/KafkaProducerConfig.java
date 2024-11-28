package com.in.config;

import com.in.avro.SessionKey;
import com.in.avro.SessionValue;
import com.in.kafka.producer.SessionKafkaProducer;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
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
    public NewTopic createTopic() {
        return new NewTopic(AppConstants.SESSION_TOPIC, 3, (short) 1);
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOTSTRAP_SERVERS);
        return new KafkaAdmin(config);
    }

    @Bean(name = "KafkaTemplate")
    public KafkaTemplate<SessionKey, SessionValue> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean(name = "session-Producer")
    public ProducerFactory<SessionKey, SessionValue> producerFactory() {
        Map<String, Object> producerConfig = new HashMap<>();
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOTSTRAP_SERVERS);
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        producerConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        return new DefaultKafkaProducerFactory<>(producerConfig);
    }


    @Bean(name="sessionProducer")
    public SessionKafkaProducer sessionProducer() {
        return new SessionKafkaProducer(kafkaTemplate());
    }
}
