package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.LoginRequestDto;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.LoginService;
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
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<DataResponse> loginRequest(@Valid @RequestBody LoginRequestDto loginDto) {
        log.info("Received request for login user with userId: {}", loginDto.toString());
        DataResponse response = loginService.loginRequest(loginDto);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }
}
