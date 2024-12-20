package com.in.controller;

import com.in.dto.ChangePasswordOnEmailRequest;
import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.ForgotPasswordService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class ForgotPasswordController {

    private static final Logger log = LoggerFactory.getLogger(ForgotPasswordController.class);

    private final ForgotPasswordService forgotPasswordService;

    public ForgotPasswordController(ForgotPasswordService forgotPasswordService) {
        this.forgotPasswordService = forgotPasswordService;
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<ResponseCode> forgotPassword(@RequestBody ChangePasswordOnEmailRequest request) {
        log.info("Request received to forgot password {}", request.getEmail());
        ResponseCode response = forgotPasswordService.forgotPassword(request.getEmail());
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }
}
