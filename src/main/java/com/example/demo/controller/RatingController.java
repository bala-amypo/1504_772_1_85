package com.example.demo.controller;

import com.example.demo.entity.RatingResult;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final RatingResultRepository ratingResultRepository;

    public RatingController(RatingService ratingService,
                            RatingResultRepository ratingResultRepository) {
        this.ratingService = ratingService;
        this.ratingResultRepository = ratingResultRepository;
    }

    @PostMapping("/generate/{propertyId}")
    public ResponseEntity<RatingResult> generate(@PathVariable Long propertyId) {
        RatingResult result = ratingService.generateRating(propertyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<RatingResult> get(@PathVariable Long propertyId) {
        RatingResult result = ratingService.getRatingByProperty(propertyId);
        return ResponseEntity.ok(result);
    }
}
