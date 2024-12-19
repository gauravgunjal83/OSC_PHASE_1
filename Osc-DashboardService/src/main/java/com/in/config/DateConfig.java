package com.in.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
public class DateConfig {

    private static final Logger log = LoggerFactory.getLogger(DateConfig.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DATE_FORMATTER;
    }

    public static String localDateToString(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    public static LocalDate stringToLocalDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            log.error("Error parsing date: {}. Expected format is yyyy-MM-dd.", dateString);
            throw new IllegalArgumentException("Invalid date format: " + dateString, e);
        }
    }
}
