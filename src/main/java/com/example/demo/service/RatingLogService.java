package com.example.demo.service;

import com.example.demo.entity.RatingLog;
import java.util.List;

public interface RatingLogService {

    RatingLog addLog(Long propertyId, Long userId, Integer rating);

    List<RatingLog> getLogsByProperty(Long propertyId);
}
