package com.in.serviceImpl;

import com.in.dto.ChangePasswordDto;
import com.in.dto.UserLoginDto;
import com.in.dto.UserRegistrationRequestDto;
import com.in.entity.UserRegistrationRequestEntity;
import com.in.exception.RecordNotFound;
import com.in.repository.UserDataRepository;
import com.in.service.UserDataService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDataServiceImpl implements UserDataService {
    private static final Logger log = LoggerFactory.getLogger(UserDataServiceImpl.class);
    private final ModelMapper mapper;
    private final UserDataRepository userDataRepository;

    public UserDataServiceImpl(ModelMapper mapper, UserDataRepository userDataRepository) {
        this.mapper = mapper;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public UserRegistrationRequestDto createUser(UserRegistrationRequestDto request) {
        UserRegistrationRequestEntity entity = mapper.map(request, UserRegistrationRequestEntity.class);
        if (entity == null)
            throw new NullPointerException("User data is empty");

        UserRegistrationRequestEntity requestEntity = userDataRepository.save(entity);
        return mapper.map(requestEntity, UserRegistrationRequestDto.class);
    }

    @Override
    public boolean isEmailAddressExists(String email) {
        return userDataRepository.existsByEmail(email);
    }

    @Transactional
    @Override
    public UserLoginDto userLoginDetails(String userId) {
        UserLoginDto credentials = userDataRepository.findNameAndPasswordByUserId(userId);
        if (credentials == null)
            throw new RecordNotFound("User record not found with this userId:" + userId);
        UserLoginDto userDto = new UserLoginDto();
        userDto.setUserId(userId);
        userDto.setName(credentials.getName());
        userDto.setPassword(credentials.getPassword());
        log.info("User credentials are: {}", userDto);
        return userDto;
    }

    @Override
    public boolean changePassword(ChangePasswordDto request) {
        int updatedCount = userDataRepository.changePasswordByEmail(request.getEmail(), request.getPassword());
        if (updatedCount == 0)
            throw new RecordNotFound("User not found with email " + request.getEmail());
        log.info("user update password.!");
        return updatedCount > 0;
    }
}
