package com.example.demo.service;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;

public interface RatingLogService {
    RatingLog addRatingLog(Property property, String message);
}
