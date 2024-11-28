package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResponseDto {

    private String userId;
    private String sessionId;
    private boolean isLogout;
}
