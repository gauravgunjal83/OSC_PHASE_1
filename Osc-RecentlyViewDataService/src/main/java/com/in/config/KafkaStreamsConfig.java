package com.in.config;

import com.in.avro.RecentViewProduct;
import com.in.kafka.serdes.RecentlyViewSerde;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.common.serialization.Serdes;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaStreamsConfig {

    @Bean(name = "streams-properties")
    public Properties streamsProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "recentlyView_application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.BOOSTRAP_SERVER);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 15);
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_DOC, 100L);
        props.put(StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, LogAndContinueExceptionHandler.class.getName());

        return props;
    }

    @Bean
    public StreamsBuilder streamsBuilder() {
        return new StreamsBuilder();
    }

    @Bean(name = "streams")
    public KafkaStreams kafkaStreams(@Qualifier("streams-properties") Properties streamsProperties, StreamsBuilder streamsBuilder) {
        recentlyViewProductKTable(streamsBuilder);

        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), streamsProperties);
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        return kafkaStreams;
    }

    @Bean
    public ReadOnlyKeyValueStore<String, RecentViewProduct> recentlyViewProductStore(@Qualifier("streams") KafkaStreams kafkaStreams) throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(100);
        }
        return kafkaStreams
                .store(StoreQueryParameters.fromNameAndType(AppConstants.RECENTLY_VIEW_PRODUCT_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public KTable<String, RecentViewProduct> recentlyViewProductKTable(StreamsBuilder streamsBuilder) {
        return streamsBuilder.table(AppConstants.RECENTLY_VIEW_PRODUCT_TOPIC, Consumed.with(Serdes.String(), RecentlyViewSerde.recentlyViewSerde()),
                Materialized.<String, RecentViewProduct, KeyValueStore<Bytes, byte[]>>as(AppConstants.RECENTLY_VIEW_PRODUCT_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(RecentlyViewSerde.recentlyViewSerde()));
    }
}
