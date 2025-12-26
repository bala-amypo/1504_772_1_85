package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
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

    @Override
    public void addLog(Long propertyId, Long userId, Integer score) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setUser(user);
        log.setScore(score);
        log.setLoggedAt(LocalDateTime.now());

        ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {
        return ratingLogRepository.findByPropertyId(propertyId);
    }
}
