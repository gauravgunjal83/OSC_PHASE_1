package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.ValidateOtpForForgotPasswordService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ValidateOtpForForgotPasswordController {

    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForForgotPasswordController.class);
    private final ValidateOtpForForgotPasswordService validateOtpService;

    public ValidateOtpForForgotPasswordController(ValidateOtpForForgotPasswordService validateOtpService) {
        this.validateOtpService = validateOtpService;
    }

    @PostMapping("/forgotPassword/validateOtp")
    public ResponseEntity<DataResponse> validateOtpForgotPassword(@Valid @RequestBody ForgotPasswordRequest passwordRequest) {
        log.info("Request received for the forgot password otp validation:{}", passwordRequest.toString());
        DataResponse response = validateOtpService.validateOtpToResetPassword(passwordRequest);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }

}
