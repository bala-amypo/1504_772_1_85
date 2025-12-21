package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;
import com.example.demo.util.ScoreCalculator;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    private final FacilityScoreRepository scoreRepo;
    private final PropertyRepository propertyRepo;

    public FacilityScoreServiceImpl(FacilityScoreRepository scoreRepo,
                                    PropertyRepository propertyRepo) {
        this.scoreRepo = scoreRepo;
        this.propertyRepo = propertyRepo;
    }

    @Override
    public FacilityScore calculateScore(Long propertyId) {

        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        return scoreRepo.findByProperty(property)
                .orElseGet(() -> {
                    FacilityScore fs = new FacilityScore();
                    fs.setProperty(property);
                    fs.setScore(ScoreCalculator.calculate(property));
                    return scoreRepo.save(fs);
                });
    }
}
