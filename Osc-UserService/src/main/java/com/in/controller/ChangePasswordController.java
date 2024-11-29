package com.in.controller;

import com.google.api.Http;
import com.in.dto.ChangePasswordRequest;
import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.ChangePasswordRequestService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class ChangePasswordController {

    private static final Logger log = LoggerFactory.getLogger(ChangePasswordController.class);
    private final ChangePasswordRequestService changePasswordRequestService;

    public ChangePasswordController(ChangePasswordRequestService changePasswordRequestService) {
        this.changePasswordRequestService = changePasswordRequestService;
    }

    @PostMapping("/changePassword")
    public ResponseEntity<ResponseCode> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        log.info("Request  received for Change password {}", changePasswordRequest.getEmail());
        ResponseCode response = changePasswordRequestService.changePassword(changePasswordRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
