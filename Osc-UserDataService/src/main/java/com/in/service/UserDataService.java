package com.in.service;

import com.in.dto.ChangePasswordDto;
import com.in.dto.UserLoginDto;
import com.in.dto.UserRegistrationRequestDto;

public interface UserDataService {

    public UserRegistrationRequestDto createUser(UserRegistrationRequestDto request);
    public boolean isEmailAddressExists(String email);
    public UserLoginDto userLoginDetails(String userId);
    public boolean changePassword(ChangePasswordDto request);

}
