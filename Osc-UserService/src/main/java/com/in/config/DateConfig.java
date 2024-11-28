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

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final Logger log = LoggerFactory.getLogger(DateConfig.class);
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
        } catch (DateTimeParseException e1) {
            try {
                DateTimeFormatter formatterAlt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(dateString, formatterAlt);
            } catch (DateTimeParseException e2) {
                log.error("Error parsing date: " + dateString + ". Expected formats are yyyy-MM-dd or dd-MM-yyyy.");
                throw new IllegalArgumentException("Invalid date format: " + dateString, e2);
            }
        }
    }
}
