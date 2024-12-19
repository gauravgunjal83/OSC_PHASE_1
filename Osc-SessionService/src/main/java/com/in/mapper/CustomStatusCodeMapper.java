package com.in.mapper;

import org.springframework.http.HttpStatus;

public class CustomStatusCodeMapper {

    public static HttpStatus mapStatusCode(int code) {
        return switch (code) {
            case 200, 201, 202, 204 -> HttpStatus.OK;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}
