package com.in.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutRequestDto {

    @NotBlank(message = "UserId can't be null or empty")
    private String userId;

    @NotBlank(message = "SessionId can't be null or empty")
    private String sessionId;
}
