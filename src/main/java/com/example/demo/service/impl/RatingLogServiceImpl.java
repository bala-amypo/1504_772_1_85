package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.entity.User;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Override
    public RatingLog addLog(Long propertyId, String message) {
        Property property = new Property();
        property.setId(propertyId);

        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }

    @Override
    public RatingLog addLog(Property property, String message) {
        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }

    @Override
    public RatingLog addLog(Property property, User user, String message) {
        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setUser(user);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {
        return ratingLogRepository.findByPropertyId(propertyId);
    }
}
