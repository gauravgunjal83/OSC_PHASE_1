package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpVerificationRequest {

    private String userId;
    @JsonProperty("OTP")
    private String OTP;
    private String email;

    @Min(value = 0, message = "Failed OTP attempts")
    @Max(value = 3, message = "Failed OTP attempts not be more than 3")
    private int failedOtpAttempts;

}
