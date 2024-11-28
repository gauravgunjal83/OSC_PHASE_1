package com.in.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Convert LocalDate to String
    public static String localDateToString(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }
    // Convert String to LocalDate
    public static LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateString, formatter);
    }
}

