package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRegistrationRequestDto {

    private String userId;

    private String name;

    private String email;

    private LocalDate dateOfBirth;

    private String mobileNumber;

    private String password;

    public UserRegistrationRequestDto() {
    }

    @Override
    public String toString() {
        return "UserRegistrationRequestDto{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
