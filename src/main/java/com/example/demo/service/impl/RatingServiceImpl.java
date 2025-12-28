package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RatingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingServiceImpl(PropertyRepository propertyRepository,
                             FacilityScoreRepository facilityScoreRepository,
                             RatingResultRepository ratingResultRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Property not found"));

        FacilityScore fs = facilityScoreRepository.findByProperty(property)
                .orElseThrow(() ->
                        new EntityNotFoundException("Facility score not found"));

        // ✅ Prevent duplicate rating
        ratingResultRepository.findByProperty(property)
                .ifPresent(r -> {
                    throw new IllegalArgumentException("Rating already exists");
                });

        double avg = (
                fs.getSchoolProximity()
                        + fs.getHospitalProximity()
                        + fs.getTransportAccess()
                        + fs.getSafetyScore()
        ) / 4.0;

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setFinalRating(avg);

        if (avg >= 8) {
            result.setRatingCategory("EXCELLENT");
        } else if (avg >= 6) {
            result.setRatingCategory("GOOD");
        } else if (avg >= 4) {
            result.setRatingCategory("AVERAGE");
        } else {
            result.setRatingCategory("POOR");
        }

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRatingByProperty(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Property not found"));

        return ratingResultRepository.findByProperty(property)
                .orElseThrow(() ->
                        new EntityNotFoundException("Rating not found"));
    }
}
