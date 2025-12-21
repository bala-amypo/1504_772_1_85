package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingLogService;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingResultRepository ratingResultRepository;
    private final PropertyRepository propertyRepository;
    private final RatingLogService ratingLogService;

    public RatingServiceImpl(FacilityScoreRepository facilityScoreRepository,
                             RatingResultRepository ratingResultRepository,
                             PropertyRepository propertyRepository,
                             RatingLogService ratingLogService) {
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingResultRepository = ratingResultRepository;
        this.propertyRepository = propertyRepository;
        this.ratingLogService = ratingLogService;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        FacilityScore score = facilityScoreRepository.findByPropertyId(propertyId)
                .orElseThrow(() -> new RuntimeException("Facility score not found"));

        double finalRating = (
                score.getSchoolProximity() +
                score.getHospitalProximity() +
                score.getTransportAccess() +
                score.getSafetyScore()
        ) / 4.0;

        String category;
        if (finalRating < 3) category = "POOR";
        else if (finalRating < 5) category = "AVERAGE";
        else if (finalRating < 8) category = "GOOD";
        else category = "EXCELLENT";

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setFinalRating(finalRating);
        result.setRatingCategory(category);

        RatingResult saved = ratingResultRepository.save(result);

        ratingLogService.addLog(propertyId, "Rating calculated: " + finalRating);
        ratingLogService.addLog(propertyId, "Category assigned: " + category);

        return saved;
    }

    @Override
    public RatingResult getRating(Long propertyId) {
        return ratingResultRepository.findByPropertyId(propertyId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
    }
}
