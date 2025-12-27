// RatingServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingResultRepository ratingResultRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public RatingServiceImpl(RatingResultRepository ratingResultRepository,
                             FacilityScoreRepository facilityScoreRepository,
                             PropertyRepository propertyRepository) {
        this.ratingResultRepository = ratingResultRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        FacilityScore fs = facilityScoreRepository.findByProperty(property)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Facility score not found"));

        double avg = (fs.getSchoolProximity()
                + fs.getHospitalProximity()
                + fs.getTransportAccess()
                + fs.getSafetyScore()) / 4.0;

        String category;
        if (avg < 4) category = "POOR";
        else if (avg < 6) category = "AVERAGE";
        else if (avg < 8) category = "GOOD";
        else category = "EXCELLENT";

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setFinalRating(avg);
        result.setRatingCategory(category);

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return ratingResultRepository.findByProperty(property)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rating not found for property"));
    }
}
