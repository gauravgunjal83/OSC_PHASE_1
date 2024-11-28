package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionResponseDto {
    private String sessionId;
    private String userId;
    private String loginDevice;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
}
