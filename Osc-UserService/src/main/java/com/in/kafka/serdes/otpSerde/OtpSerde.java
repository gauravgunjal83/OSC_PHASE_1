package com.in.kafka.serdes.otpSerde;

import com.in.avro.OtpMessage;
import com.in.config.AppConstant;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class OtpSerde extends Serdes {

    public static Serde<OtpMessage> OtpSerde(){
        Serde<OtpMessage> serde = new SpecificAvroSerde<>();
        Map<String, Object> serdeConfig = new HashMap<>();
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstant.SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfig,false);
        return serde;
    }
}
