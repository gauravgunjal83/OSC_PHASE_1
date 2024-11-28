package com.in.controller;

import com.in.dto.DataResponse;
import com.in.dto.LogoutRequestDto;
import com.in.mapper.CustomStatusCodeMapper;
import com.in.service.LogoutRequestService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class LogoutController {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

    private final LogoutRequestService logoutRequestService;

    public LogoutController(LogoutRequestService logoutRequestService) {
        this.logoutRequestService = logoutRequestService;
    }

    @PostMapping("/logout")
    public ResponseEntity<DataResponse> logoutUser(@Valid @RequestBody LogoutRequestDto logoutRequest) {
        log.info("Request Received for the logout user session with sessionId : {}", logoutRequest.getSessionId());
        DataResponse response = logoutRequestService.logoutUser(logoutRequest);
        return ResponseEntity.status(CustomStatusCodeMapper.mapStatusCode(response.getCode())).body(response);
    }
}
