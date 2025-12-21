package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingResultRepository ratingResultRepository;
    private final FacilityScoreRepository scoreRepository;
    private final PropertyRepository propertyRepository;

    public RatingServiceImpl(RatingResultRepository ratingResultRepository,
                             FacilityScoreRepository scoreRepository,
                             PropertyRepository propertyRepository) {
        this.ratingResultRepository = ratingResultRepository;
        this.scoreRepository = scoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property not found"));

        FacilityScore score = scoreRepository.findByProperty(property)
                .orElseThrow(() ->
                        new IllegalArgumentException("Facility score not found"));

        double finalRating = (
                score.getSchoolProximity()
                        + score.getHospitalProximity()
                        + score.getTransportAccess()
                        + score.getSafetyScore()
        ) / 4.0;

        String category;
        if (finalRating < 3) category = "POOR";
        else if (finalRating < 6) category = "AVERAGE";
        else if (finalRating < 8) category = "GOOD";
        else category = "EXCELLENT";

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setFinalRating(finalRating);
        result.setRatingCategory(category);

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property not found"));

        return ratingResultRepository.findByProperty(property)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rating not found"));
    }
}
