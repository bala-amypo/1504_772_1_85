package com.example.demo.service;

import com.example.demo.entity.RatingLog;
import java.util.List;

public interface RatingLogService {

    RatingLog addLog(Long propertyId, Long userId, Long ratingId, Integer score);

    List<RatingLog> getLogsByProperty(Long propertyId);
}
