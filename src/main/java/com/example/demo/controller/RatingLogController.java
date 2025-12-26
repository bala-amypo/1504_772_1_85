package com.example.demo.controller;

import com.example.demo.entity.RatingLog;
import com.example.demo.service.RatingLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating-logs")
public class RatingLogController {

    @Autowired
    private RatingLogService ratingLogService;

    @PostMapping
    public RatingLog addLog(
            @RequestParam Long propertyId,
            @RequestParam Long userId,
            @RequestParam Long ratingId,
            @RequestParam Integer score
    ) {
        return ratingLogService.addLog(propertyId, userId, ratingId, score);
    }
}
