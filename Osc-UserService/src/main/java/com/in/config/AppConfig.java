package com.in.config;

import com.in.proto.UserDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    }

    @Bean
    public UserDataServiceGrpc.UserDataServiceBlockingStub userDataServiceBlockingStub (){
        return UserDataServiceGrpc.newBlockingStub(managedChannel());
    }
}