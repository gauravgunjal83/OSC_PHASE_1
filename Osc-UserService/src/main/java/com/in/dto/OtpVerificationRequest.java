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

//    public OtpVerificationRequest(String userId, String OTP, String email, int failedOtpAttempts) {
//        this.userId = userId;
//        this.OTP = OTP;
//        this.email = email;
//        this.failedOtpAttempts = failedOtpAttempts;
//    }
//
//    public OtpVerificationRequest() {
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getOTP() {
//        return OTP;
//    }
//
//    public void setOTP(String OTP) {
//        this.OTP = OTP;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getFailedOtpAttempts() {
//        return failedOtpAttempts;
//    }
//
//    public void setFailedOtpAttempts(int failedOtpAttempts) {
//        this.failedOtpAttempts = failedOtpAttempts;
//    }
}
