package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.ForgotPasswordRequest;
import com.in.dto.ResponseCode;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.ValidateOtpForForgotPasswordService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class ValidateOtpForForgotPasswordController {

    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForForgotPasswordController.class);
    private final ValidateOtpForForgotPasswordService validateOtpService;

    public ValidateOtpForForgotPasswordController(ValidateOtpForForgotPasswordService validateOtpService) {
        this.validateOtpService = validateOtpService;
    }

    @PostMapping("/forgotPassword/validateOtp")
    public ResponseEntity<ResponseCode> validateOtpForgotPassword(@Valid @RequestBody ForgotPasswordRequest passwordRequest) {
        log.info("Request received for the forgot password otp validation:{}", passwordRequest.toString());
        ResponseCode response = validateOtpService.validateOtpToResetPassword(passwordRequest);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }

}
