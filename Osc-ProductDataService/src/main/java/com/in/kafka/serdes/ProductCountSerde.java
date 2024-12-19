package com.in.kafka.serdes;

import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.config.AppConstants;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class ProductCountSerde extends Serdes {

    public static Serde<ProductViewCount> productCountSerde(){
        Serde<ProductViewCount> serde =  new SpecificAvroSerde<>();
        Map<String, Object> config= new HashMap<>();
        config.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstants.SCHEMA_REGISTRY_URL);
        serde.configure(config,false);
        return  serde;
    }
}
