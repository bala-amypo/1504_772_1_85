package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.entity.User;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository ratingLogRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public RatingLogServiceImpl(RatingLogRepository ratingLogRepository,
                                PropertyRepository propertyRepository,
                                UserRepository userRepository) {
        this.ratingLogRepository = ratingLogRepository;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    /**
     * Used by controller & integration tests
     */
    @Override
    public RatingLog addLog(Long propertyId, Long userId, String message) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setUser(user);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }

    /**
     * Used by tests
     */
    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {
        return ratingLogRepository.findByPropertyId(propertyId);
    }
}
