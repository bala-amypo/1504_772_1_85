package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    private final FacilityScoreRepository scoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreServiceImpl(FacilityScoreRepository scoreRepository,
                                    PropertyRepository propertyRepository) {
        this.scoreRepository = scoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public FacilityScore addScore(Long propertyId, FacilityScore score) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property not found with id: " + propertyId));

        if (scoreRepository.findByProperty(property).isPresent()) {
            throw new IllegalArgumentException("Facility score already exists for this property");
        }

        validateScore(score.getSchoolProximity());
        validateScore(score.getHospitalProximity());
        validateScore(score.getTransportAccess());
        validateScore(score.getSafetyScore());

        score.setProperty(property);
        return scoreRepository.save(score);
    }

    @Override
    public FacilityScore getScoreByProperty(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Property not found with id: " + propertyId));

        return scoreRepository.findByProperty(property)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Facility score not found"));
    }

    private void validateScore(Integer value) {
        if (value < 0 || value > 10) {
            throw new IllegalArgumentException("Score must be between 0 and 10");
        }
    }
}
