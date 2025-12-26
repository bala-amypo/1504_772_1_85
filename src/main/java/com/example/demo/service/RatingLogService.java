package com.example.demo.service;

import com.example.demo.entity.RatingLog;
import java.util.List;

public interface RatingLogService {

    // propertyId, ratingId, userId, score
    void addLog(Long propertyId, Long ratingId, Long userId, Integer score);

    List<RatingLog> getLogsByProperty(Long propertyId);
}
