package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final PropertyRepository propertyRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingServiceImpl(PropertyRepository propertyRepository,
                             RatingResultRepository ratingResultRepository) {
        this.propertyRepository = propertyRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @Override
    public RatingResult calculateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        double score = property.getPrice() / property.getAreaSqFt();

        RatingResult result = new RatingResult();
        result.setProperty(property);
        result.setScore(score);

        return ratingResultRepository.save(result);
    }
}
