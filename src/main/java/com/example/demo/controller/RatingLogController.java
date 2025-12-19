package com.example.demo.controller;

import com.example.demo.entity.RatingLog;
import com.example.demo.service.RatingLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
@Tag(name = "Rating Logs")
public class RatingLogController {

    private final RatingLogService ratingLogService;

    public RatingLogController(RatingLogService ratingLogService) {
        this.ratingLogService = ratingLogService;
    }

    @PostMapping("/{propertyId}")
    @Operation(summary = "Add rating log")
    public RatingLog addLog(@PathVariable Long propertyId,
                            @RequestParam String message) {
        return ratingLogService.addLog(propertyId, message);
    }

    @GetMapping("/property/{propertyId}")
    @Operation(summary = "Get logs by property")
    public List<RatingLog> getLogs(@PathVariable Long propertyId) {
        return ratingLogService.getLogsByProperty(propertyId);
    }
}
