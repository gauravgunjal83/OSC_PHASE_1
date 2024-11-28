package com.in.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    @NotEmpty(message = "Email cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Enter correct Email")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be include at least 8 characters long,\n and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;
}
