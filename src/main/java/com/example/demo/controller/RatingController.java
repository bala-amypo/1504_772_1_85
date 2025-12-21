package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RatingResult;
import com.example.demo.service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @PostMapping("/generate/{propertyId}")
    public ApiResponse generateRating(@PathVariable Long propertyId) {
        RatingResult result = service.generateRating(propertyId);
        return new ApiResponse(true, "Rating generated", result);
    }

    @GetMapping("/property/{propertyId}")
    public ApiResponse getRating(@PathVariable Long propertyId) {
        return new ApiResponse(true, "Rating fetched",
                service.getRating(propertyId));
    }
}
