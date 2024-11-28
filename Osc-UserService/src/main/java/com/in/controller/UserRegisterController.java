package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.RegistrationRequest;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.RegisterUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegisterController {

    private static final Logger log = LoggerFactory.getLogger(UserRegisterController.class);

   /* public UserRegisterController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }*/

    private final RegisterUserService registerUserService;

    @PostMapping("/")
    public ResponseEntity<DataResponse> registerUser(@Valid @RequestBody RegistrationRequest request) {
        log.info("Create user request received: {}", request);
        DataResponse dataResponse = registerUserService.registerUser(request);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(dataResponse.getCode())).body(dataResponse);
    }
    
}
