package com.in.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.protobuf.Message;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserializer() {
        return builder -> {
            builder.serializerByType(Message.class, new ProtobufSerializer());
        };
    }
}
    @SuppressWarnings("serial")
     class ProtobufSerializer extends StdSerializer<Message> {

        public ProtobufSerializer() {
            super(Message.class);
        }

        @Override
        public void serialize(Message message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(message.toString());
        }
    }
