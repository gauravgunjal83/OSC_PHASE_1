package com.in.serviceImpl;

import com.in.dto.CreateSessionDto;
import com.in.dto.SessionResponseDto;
import com.in.entity.SessionEntity;
import com.in.mapper.Mapper;
import com.in.repository.SessionRepository;
import com.in.service.LoginRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginRequestServiceImpl implements LoginRequestService {
    private final ModelMapper modelMapper;
    private final SessionRepository sessionRepository;

    public LoginRequestServiceImpl(ModelMapper modelMapper, SessionRepository sessionRepository) {
        this.modelMapper = modelMapper;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionResponseDto createSession(CreateSessionDto sessionDto) {
        SessionResponseDto response = Mapper.dtoToSessionResponseEntity(sessionDto);
        if (response == null) {
            throw new NullPointerException("Session is null");
        }
        SessionEntity entity = sessionRepository.save(modelMapper.map(response, SessionEntity.class));
        return modelMapper.map(entity, SessionResponseDto.class);
    }
}
