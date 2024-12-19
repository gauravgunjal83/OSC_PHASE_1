package com.in.mapper;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class CustomStatusCodeMapper {

    public static final Map<Integer, HttpStatus> STATUS_CODE_MAP = Map.of(

            30, HttpStatus.OK,
            200, HttpStatus.OK,
            220, HttpStatus.BAD_REQUEST,
            301, HttpStatus.OK,
            502, HttpStatus.OK,
            1999, HttpStatus.NOT_FOUND,
            199, HttpStatus.OK,
            500, HttpStatus.OK,
            0, HttpStatus.INTERNAL_SERVER_ERROR

    );

    public static HttpStatus mapStatusCode(int code) {
        return STATUS_CODE_MAP.getOrDefault(code, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
