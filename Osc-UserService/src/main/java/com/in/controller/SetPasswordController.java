package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.ResponseCode;
import com.in.dto.SetPasswordRequest;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.SetPasswordService;
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
public class SetPasswordController {

    private static final Logger log = LoggerFactory.getLogger(SetPasswordController.class);

    private final SetPasswordService passwordService;

    public SetPasswordController(SetPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/setPassword")
    public ResponseEntity<ResponseCode>  setPassword(@Valid @RequestBody SetPasswordRequest passwordRequest){
        log.info("Received request for set the password: {}", passwordRequest.toString());
        ResponseCode dataResponse = passwordService.setUserPassword(passwordRequest);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(dataResponse.getCode())).body(dataResponse);
    }

}
