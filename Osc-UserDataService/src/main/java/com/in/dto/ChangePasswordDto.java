package com.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {

    @NotEmpty(message = "Email can't be null")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Enter correct Email format")
    private String email;

    @NotBlank(message = "Password not be null or empty")
    private String password;
}
