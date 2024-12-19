package com.in.config;


import com.in.avro.CategoryDetails;
import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.kafka.serdes.CategorySerde;
import com.in.kafka.serdes.ProductCountSerde;
import com.in.kafka.serdes.ProductSerde;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Properties;

@Configuration
public class KafkaStreamConfig {

    @Bean(name = "streams-properties")
    public Properties streamsProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "Dashboard_application");
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
    public KafkaStreams kafkaStreams(@Qualifier("streams-properties") Properties streamsProperties,
                                     StreamsBuilder streamsBuilder) {
        productGlobalKTable(streamsBuilder);
        categoryGlobalKTable(streamsBuilder);
        productViewCountKTable(streamsBuilder);

        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), streamsProperties);
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        return kafkaStreams;
    }

    @Bean
    @DependsOn("streams")
    public ReadOnlyKeyValueStore<String, ProductDetails> productStore(@Qualifier("streams") KafkaStreams kafkaStreams)
            throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(100);
        }
        return kafkaStreams.store(
                StoreQueryParameters.fromNameAndType(AppConstants.PRODUCT_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public GlobalKTable<String, ProductDetails> productGlobalKTable(StreamsBuilder streamsBuilder) {
        return streamsBuilder.globalTable(AppConstants.PRODUCT_TOPIC,
                Consumed.with(Serdes.String(), ProductSerde.productSerde()),
                Materialized.<String, ProductDetails, KeyValueStore<Bytes, byte[]>>as(AppConstants.PRODUCT_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(ProductSerde.productSerde()));
    }

    @Bean
    @DependsOn("streams")
    public ReadOnlyKeyValueStore<String, CategoryDetails> categoryStore(@Qualifier("streams") KafkaStreams kafkaStreams)
            throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(100);
        }
        return kafkaStreams.store(
                StoreQueryParameters.fromNameAndType(AppConstants.CATEGORY_STORE, QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public GlobalKTable<String, CategoryDetails> categoryGlobalKTable(StreamsBuilder streamsBuilder) {
        return streamsBuilder.globalTable(AppConstants.CATEGORY_TOPIC,
                Consumed.with(Serdes.String(), CategorySerde.categorySerde()),
                Materialized.<String, CategoryDetails, KeyValueStore<Bytes, byte[]>>as(AppConstants.CATEGORY_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(CategorySerde.categorySerde()));
    }

    @Bean
    @DependsOn("streams")
    public ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore(@Qualifier("streams") KafkaStreams kafkaStreams) throws InterruptedException {
        while (kafkaStreams.state() != KafkaStreams.State.RUNNING) {
            Thread.sleep(100);
        }
        return kafkaStreams.store(StoreQueryParameters.fromNameAndType(AppConstants.PRODUCT_VIEWCOUNT_STORE,
                QueryableStoreTypes.keyValueStore()));
    }

    @Bean
    public KTable<String, ProductViewCount> productViewCountKTable(StreamsBuilder streamsBuilder) {
        return streamsBuilder.table(AppConstants.PRODUCT_VIEWCOUNT_TOPIC,
                Consumed.with(Serdes.String(), ProductCountSerde.productCountSerde()),
                Materialized
                        .<String, ProductViewCount, KeyValueStore<Bytes, byte[]>>as(AppConstants.PRODUCT_VIEWCOUNT_STORE)
                        .withKeySerde(Serdes.String()).withValueSerde(ProductCountSerde.productCountSerde()));
    }
}
