package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.repository.RatingLogRepository;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository ratingLogRepository;

    public RatingLogServiceImpl(RatingLogRepository ratingLogRepository) {
        this.ratingLogRepository = ratingLogRepository;
    }

    @Override
    public RatingLog addRatingLog(Property property, String message) {
        RatingLog log = new RatingLog(property, message);
        return ratingLogRepository.save(log);
    }
}
