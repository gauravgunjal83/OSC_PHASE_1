package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.OtpValidateDtoRequest;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.ValidateOtpForSetPasswordService;
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
public class ValidateOtpForSetPasswordController {

    private static final Logger log = LoggerFactory.getLogger(ValidateOtpForSetPasswordController.class);
    private ValidateOtpForSetPasswordService validateOtpService;

    public ValidateOtpForSetPasswordController(ValidateOtpForSetPasswordService validateOtpService) {
        this.validateOtpService = validateOtpService;
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<DataResponse> validateOtpForSetPassword(@Valid @RequestBody OtpValidateDtoRequest request){
        log.info("Request received for validate OTP: {}",request.toString());
        DataResponse response = validateOtpService.validateOtpForSetPassword(request);
        return  ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }

}
