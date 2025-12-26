package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.entity.User;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public RatingLog addLog(Long propertyId, Long userId, Integer rating) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setUser(user);
        log.setRating(rating);
        log.setLoggedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        return ratingLogRepository.findByProperty(property);
    }
}
