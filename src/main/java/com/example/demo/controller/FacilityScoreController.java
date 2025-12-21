package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final FacilityScoreService service;

    public FacilityScoreController(FacilityScoreService service) {
        this.service = service;
    }

    @PostMapping("/{propertyId}")
    public ApiResponse addScore(@PathVariable Long propertyId,
                                @RequestBody FacilityScore score) {
        return new ApiResponse(true, "Score added",
                service.addScore(propertyId, score));
    }

    @GetMapping("/{propertyId}")
    public ApiResponse getScore(@PathVariable Long propertyId) {
        return new ApiResponse(true, "Score fetched",
                service.getScoreByProperty(propertyId));
    }
}
