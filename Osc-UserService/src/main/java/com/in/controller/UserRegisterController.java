package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.RegistrationRequestDto;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.SignupUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserRegisterController {

    private static final Logger log = LoggerFactory.getLogger(UserRegisterController.class);
    private final SignupUserService signupUserService;

    @PostMapping("/signup")
    public ResponseEntity<DataResponse> signupUser(@Valid @RequestBody RegistrationRequestDto request) {
        log.info("Create user request received: {}", request);
        DataResponse dataResponse = signupUserService.signupUser(request);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(dataResponse.getCode())).body(dataResponse);
    }
    
}
