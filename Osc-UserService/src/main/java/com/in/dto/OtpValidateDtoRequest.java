package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OtpValidateDtoRequest {

    @NotEmpty(message = "UserId can't be blank or null")
    private String userId;

    @NotEmpty
    @JsonProperty("OTP")
    private String OTP;
}
