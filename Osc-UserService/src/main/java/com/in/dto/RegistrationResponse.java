package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {

    private String userId;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String mobileNumber;
    private String password;

}
