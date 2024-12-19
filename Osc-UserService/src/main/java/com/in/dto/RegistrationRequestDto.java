package com.in.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.time.LocalDate;

@Data
public class RegistrationRequestDto {

    @NotBlank
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z\\s-_]+$", message = "Enter name in correct format")
    private String name;

    @NotBlank
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Enter correct email")
    private String email;

    @NotNull(message = "DOB cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;

    @NotBlank(message = "Mobile number can't be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Please enter 10 digit mobile number")
    private String contact;

}
