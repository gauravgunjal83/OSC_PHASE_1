package com.in.dto;

import com.in.avro.SessionKey;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequestDto {

    @NotBlank(message = "Session Id can't be null or empty")
    private SessionKey sessionId;

    private boolean isActive;
}
