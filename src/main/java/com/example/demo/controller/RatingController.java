package com.example.demo.controller;

import com.example.demo.entity.RatingResult;
import com.example.demo.service.RatingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
@Tag(name = "Ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/generate/{propertyId}")
    @Operation(summary = "Generate rating")
    public RatingResult generateRating(@PathVariable Long propertyId) {
        return ratingService.generateRating(propertyId);
    }

    @GetMapping("/property/{propertyId}")
    @Operation(summary = "Get rating result")
    public RatingResult getRating(@PathVariable Long propertyId) {
        return ratingService.getRating(propertyId);
    }
}
