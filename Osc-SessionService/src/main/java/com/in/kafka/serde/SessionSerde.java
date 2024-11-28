package com.in.kafka.serde;

import com.in.avro.SessionKey;
import com.in.avro.SessionValue;
import com.in.config.AppConstants;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class SessionSerde extends Serdes {

    public static SpecificAvroSerde<SessionKey> sessionKeySerde() {
        SpecificAvroSerde<SessionKey> serde = new SpecificAvroSerde<>();
        Map<String, Object> serdeConfig = new HashMap<>();
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfig, true);
        return serde;

    }

    public static Serde<SessionValue> sessionValueSerde() {
        Serde<SessionValue> serde = new SpecificAvroSerde<>();
        Map<String, Object> serdeConfig = new HashMap<>();
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfig, false);
        return serde;
    }
}
