package com.in.kafka.serdes;

import com.in.avro.RecentViewProduct;
import com.in.config.AppConstants;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class RecentlyViewSerde extends Serdes {

    public static Serde<RecentViewProduct> recentlyViewSerde() {
        Serde<RecentViewProduct> serde = new SpecificAvroSerde<>();
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        serde.configure(configMap, false);
        return serde;
    }


}
