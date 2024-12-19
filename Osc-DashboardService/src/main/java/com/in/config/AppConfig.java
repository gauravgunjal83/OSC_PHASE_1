package com.in.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.protobuf.Message;
import com.in.ProductHistory.RecentlyViewServiceGrpc;
import com.in.Session.SessionServiceGrpc;
import com.in.cart.CartDataProductServiceGrpc;
import com.in.dashboard.ProductDashboardServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.support.ManagedArray;
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
    public ManagedChannel sessionChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
    }
    @Bean
    public ManagedChannel productChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9099).usePlaintext().build();
    }

    @Bean
    public ManagedChannel recentlyViewProductChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
    }

    @Bean
    public ManagedChannel cartProductChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9082).usePlaintext().build();
    }

    @Bean
    public SessionServiceGrpc.SessionServiceBlockingStub sessionServiceBlockingStub() {
        return SessionServiceGrpc.newBlockingStub(sessionChannel());
    }

    @Bean
    public ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productDashboardServiceBlockingStub() {
        return ProductDashboardServiceGrpc.newBlockingStub(productChannel());
    }

    @Bean
    public RecentlyViewServiceGrpc.RecentlyViewServiceBlockingStub recentlyViewServiceBlockingStub() {
        return RecentlyViewServiceGrpc.newBlockingStub(recentlyViewProductChannel());
    }

    @Bean
    public CartDataProductServiceGrpc.CartDataProductServiceBlockingStub cartDataProductServiceBlockingStub() {
        return CartDataProductServiceGrpc.newBlockingStub(cartProductChannel());
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



