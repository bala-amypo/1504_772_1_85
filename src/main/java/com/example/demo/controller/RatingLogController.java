package com.example.demo.controller;

import com.example.demo.entity.RatingLog;
import com.example.demo.service.RatingLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating-log")
public class RatingLogController {

    @Autowired
    private RatingLogService ratingLogService;

    @PostMapping("/add")
    public ResponseEntity<RatingLog> addLog(
            @RequestParam Long userId,
            @RequestParam Long propertyId,
            @RequestParam Long ratingId,
            @RequestParam Integer score) {

        RatingLog log = ratingLogService.addLog(
                userId, propertyId, ratingId, score);

        return ResponseEntity.ok(log);
    }
}
