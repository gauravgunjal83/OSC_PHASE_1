package com.in.config;

import com.in.avro.OtpMessage;
import com.in.avro.User;
import com.in.kafka.serdes.otpSerde.OtpSerde;
import com.in.kafka.serdes.userSerde.UserSerde;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaStreamConfig {

    @Bean(name = "streams-properties")
    public Properties streamsProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "OSC-Application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.BOOTSTRAP_SERVERS);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstant.SCHEMA_REGISTRY_URL);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, UserSerde.User().getClass().getName());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_DOC, 100L);
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 15);
        return props;
    }

    @Bean(name = "streams-builder")
    public StreamsBuilder streamsBuilder() {
        return new StreamsBuilder();
    }

    @Bean(name = "streams")
    public KafkaStreams kafkaStreams(@Qualifier("streams-properties") Properties streamsProps, @Qualifier("streams-builder") StreamsBuilder streamsBuilder) {
        userKTable(streamsBuilder);
        otpMessageKTable(streamsBuilder);
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), streamsProps);
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        return kafkaStreams;
    }

    @Bean
    public ReadOnlyKeyValueStore<String, User> userStore(@Qualifier("streams") KafkaStreams kafkaStreams) throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(1000);
        }
        return kafkaStreams.store(StoreQueryParameters.fromNameAndType(AppConstant.USER_REGISTRATION_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public ReadOnlyKeyValueStore<String, OtpMessage> otpStore(@Qualifier("streams") KafkaStreams kafkaStreams) throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(1000);
        }
        return kafkaStreams.store(StoreQueryParameters.fromNameAndType(AppConstant.OTP_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean(name = "otp-table")
    public KTable<String, OtpMessage> otpMessageKTable(@Qualifier("streams-builder") StreamsBuilder streamsBuilder) {
        return streamsBuilder.table(AppConstant.OTP_TOPIC, Consumed.with(Serdes.String(), OtpSerde.OtpSerde()),
                Materialized.<String, OtpMessage, KeyValueStore<Bytes, byte[]>>as(AppConstant.OTP_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(OtpSerde.OtpSerde()));

    }

    @Bean(name = "user-table")
    public KTable<String, User> userKTable(@Qualifier("streams-builder") StreamsBuilder streamsBuilder) {
        return streamsBuilder.table(AppConstant.USER_REGISTRATION_TOPIC, Consumed.with(Serdes.String(), UserSerde.User()),
                Materialized.<String, User, KeyValueStore<Bytes, byte[]>>as(AppConstant.USER_REGISTRATION_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(UserSerde.User()));
    }
}
