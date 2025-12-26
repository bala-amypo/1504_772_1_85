package com.example.demo.service;

import com.example.demo.entity.RatingLog;

public interface RatingLogService {

    RatingLog addLog(Long userId,
                     Long propertyId,
                     Long ratingId,
                     Integer score);
}
