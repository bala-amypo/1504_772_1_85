package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RatingLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingLogServiceImpl implements RatingLogService {

    private final RatingLogRepository repo;
    private final PropertyRepository propertyRepo;

    public RatingLogServiceImpl(RatingLogRepository repo,
                                PropertyRepository propertyRepo) {
        this.repo = repo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public RatingLog addLog(Long propertyId, String message) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return repo.save(new RatingLog(property, message, null));
    }

    @Override
    public List<RatingLog> getLogsByProperty(Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        return repo.findByProperty(property);
    }
}
