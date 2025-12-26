package com.example.demo.service.impl;

import com.example.demo.entity.RatingLog;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Override
    public RatingLog addLog(Long userId,
                            Long propertyId,
                            Long ratingId,
                            Integer score) {

        RatingLog log = new RatingLog();
        log.setUserId(userId);
        log.setPropertyId(propertyId);
        log.setRatingId(ratingId);
        log.setScore(score);
        log.setCreatedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }
}
