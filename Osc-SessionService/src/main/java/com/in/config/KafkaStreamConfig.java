package com.in.config;

import com.in.avro.SessionKey;
import com.in.avro.SessionValue;
import com.in.kafka.serde.SessionSerde;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaStreamConfig {

    @Bean
    public StreamsBuilder streamsBuilder() {
        return new StreamsBuilder();
    }

    @Bean
    public Properties streamsProperties() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "Session_application");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOTSTRAP_SERVERS);
        properties.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, SessionSerde.sessionKeySerde().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SessionSerde.sessionValueSerde().getClass().getName());
        properties.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 15);
        properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_DOC, 100L);
        properties.put(StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, LogAndContinueExceptionHandler.class.getName());

        return properties;
    }

    @Bean
    public KafkaStreams kafkaStreams(Properties streamsProperties, StreamsBuilder streamsBuilder) {
        sessionKTable(streamsBuilder);
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), streamsProperties);
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        return kafkaStreams;
    }


    @Bean
    public ReadOnlyKeyValueStore<SessionKey, SessionValue> sessionStore(KafkaStreams kafkaStreams) throws InterruptedException {

        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(100);
        }
        return kafkaStreams
                .store(StoreQueryParameters.fromNameAndType(AppConstants.SESSION_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public KTable<SessionKey, SessionValue> sessionKTable(StreamsBuilder streamsBuilder) {
        return streamsBuilder.table(AppConstants.SESSION_TOPIC, Consumed.with(SessionSerde.sessionKeySerde(), SessionSerde.sessionValueSerde()),
                Materialized.<SessionKey, SessionValue, KeyValueStore<Bytes, byte[]>>as(AppConstants.SESSION_STORE).withKeySerde(SessionSerde.sessionKeySerde()).withValueSerde(SessionSerde.sessionValueSerde()));

    }
}
