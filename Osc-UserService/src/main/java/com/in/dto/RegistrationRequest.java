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
public class RegistrationRequest {

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

//    public RegistrationRequest() {
//    }
//
//    public RegistrationRequest(String name, String email, LocalDate DOB, String contact) {
//        this.name = name;
//        this.email = email;
//        this.DOB = DOB;
//        this.contact = contact;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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
//    public LocalDate getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(LocalDate DOB) {
//        this.DOB = DOB;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
}
