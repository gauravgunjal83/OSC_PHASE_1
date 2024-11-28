package com.in.kafka.serdes.userSerde;

import com.in.avro.User;
import com.in.config.AppConstant;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class UserSerde  extends Serdes {

    public static Serde<User> User(){
        Serde<User> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfig = new HashMap<>();
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, AppConstant.SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfig,false);
        return serde;
    }
}
