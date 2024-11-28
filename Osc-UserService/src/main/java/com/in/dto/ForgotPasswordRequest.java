package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {

    private String email;
    @JsonProperty("OTP")
    private String OTP;
    @Min(value = 0, message = "Failed OTP attempts")
    @Max(value = 3, message = "Failed OTP attempts not be more than 3")
    private int failedOtpAttempts;

}
