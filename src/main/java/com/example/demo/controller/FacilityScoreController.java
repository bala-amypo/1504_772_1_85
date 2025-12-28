package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.http.*;
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
                                    @RequestBody FacilityScore score) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow();

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
                .orElseThrow();

        FacilityScore score = facilityScoreRepository.findByProperty(property)
                .orElseThrow();

        return ResponseEntity.ok(score);
    }
}
