package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingResultRepository ratingRepo;
    private final FacilityScoreRepository scoreRepo;
    private final PropertyRepository propertyRepo;

    public RatingServiceImpl(RatingResultRepository ratingRepo,
                             FacilityScoreRepository scoreRepo,
                             PropertyRepository propertyRepo) {
        this.ratingRepo = ratingRepo;
        this.scoreRepo = scoreRepo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        FacilityScore s = scoreRepo.findByProperty(property)
                .orElseThrow(() -> new IllegalArgumentException("Facility score missing"));

        double avg = (s.getSchoolProximity() + s.getHospitalProximity()
                + s.getTransportAccess() + s.getSafetyScore()) / 4.0;

        String category =
                avg < 3 ? "POOR" :
                avg < 6 ? "AVERAGE" :
                avg < 8 ? "GOOD" : "EXCELLENT";

        RatingResult result = new RatingResult(property, avg, category, null);
        return ratingRepo.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingRepo.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
    }
}
