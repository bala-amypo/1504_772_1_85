package com.example.demo.controller;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;

    public FacilityScoreController(PropertyRepository propertyRepository,
                                   FacilityScoreRepository facilityScoreRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<?> create(@PathVariable Long propertyId,
                                    @Valid @RequestBody FacilityScore score) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Property not found"));

        if (facilityScoreRepository.findByProperty(property).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        score.setProperty(property);
        FacilityScore saved = facilityScoreRepository.save(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<FacilityScore> get(@PathVariable Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Property not found"));

        FacilityScore score = facilityScoreRepository.findByProperty(property)
                .orElseThrow(() ->
                        new EntityNotFoundException("Facility score not found"));

        return ResponseEntity.ok(score);
    }
}
