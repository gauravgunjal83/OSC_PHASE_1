package com.in.mapper;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class CustomStatusCodeMapper {

    public static final Map<Integer, HttpStatus> STATUS_CODE_MAP = Map.of(

            30, HttpStatus.OK,                 //Email already registered
            200, HttpStatus.OK,                   // Success (both OTP correct and user creation success)
            220, HttpStatus.BAD_REQUEST,          // User creation failed (bad request)
            301, HttpStatus.OK,                   // Maximum OTP attempts reached
            502, HttpStatus.OK,                   // Invalid OTP
            1999, HttpStatus.NOT_FOUND,           // UserId not found
            199, HttpStatus.OK,                   // Wrong Email or OTP invalid
            500, HttpStatus.OK,                   // OTP validated successfully
            0, HttpStatus.INTERNAL_SERVER_ERROR   // Internal Server Error

    );

    public static HttpStatus mapStatusCode(int code){
        return  STATUS_CODE_MAP.getOrDefault(code, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
