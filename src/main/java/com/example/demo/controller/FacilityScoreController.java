package com.example.demo.controller;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
@Tag(name = "Facility Scores")
public class FacilityScoreController {

    private final FacilityScoreService facilityScoreService;

    public FacilityScoreController(FacilityScoreService facilityScoreService) {
        this.facilityScoreService = facilityScoreService;
    }

    @PostMapping("/{propertyId}")
    @Operation(summary = "Submit facility score")
    public FacilityScore addScore(@PathVariable Long propertyId,
                                  @RequestBody FacilityScore score) {
        return facilityScoreService.addScore(propertyId, score);
    }

    @GetMapping("/{propertyId}")
    @Operation(summary = "Get facility score by property")
    public FacilityScore getScore(@PathVariable Long propertyId) {
        return facilityScoreService.getScoreByProperty(propertyId);
    }
}
