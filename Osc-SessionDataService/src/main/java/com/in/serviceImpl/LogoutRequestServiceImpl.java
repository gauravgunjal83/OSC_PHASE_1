package com.in.serviceImpl;

import com.in.dto.LogoutRequestDto;
import com.in.dto.LogoutResponseDto;
import com.in.entity.SessionEntity;
import com.in.exception.RecordNotFoundException;
import com.in.repository.SessionRepository;
import com.in.service.LogoutRequestService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LogoutRequestServiceImpl implements LogoutRequestService {
    private static final Logger log = LoggerFactory.getLogger(LogoutRequestServiceImpl.class);
    private final SessionRepository sessionRepository;

    public LogoutRequestServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    @Transactional
    public LogoutResponseDto logoutUser(LogoutRequestDto logoutRequest) {
        String sessionId = logoutRequest.getSessionId();
        SessionEntity sessionData = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RecordNotFoundException("Session not found with sessionId " + sessionId));
        if (sessionData.getLogoutTime() == null && sessionData.getLoginTime() != null) {
            sessionData.setLogoutTime(LocalDateTime.now());
            sessionRepository.save(sessionData);

            log.info("Session logged out successfully for sessionId: {}", sessionId);
            return new LogoutResponseDto(sessionData.getUserId(), sessionData.getLoginDevice(), true);
        }
        log.warn("Session already logged out or not valid for sessionId: {}", sessionId);
        return new LogoutResponseDto(sessionData.getUserId(), sessionData.getLoginDevice(), false);
    }

}
