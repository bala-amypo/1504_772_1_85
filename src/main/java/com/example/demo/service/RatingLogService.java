package com.example.demo.service;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import com.example.demo.entity.User;

import java.util.List;

public interface RatingLogService {

    RatingLog addLog(Long propertyId, String message);

    RatingLog addLog(Property property, String message);

    RatingLog addLog(Property property, User user, String message);

    List<RatingLog> findByPropertyId(Long propertyId);
}
