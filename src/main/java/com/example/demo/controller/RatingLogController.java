package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.RatingLog;
import com.example.demo.service.RatingLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class RatingLogController {

    private final RatingLogService service;

    public RatingLogController(RatingLogService service) {
        this.service = service;
    }

    @PostMapping("/{propertyId}")
    public ApiResponse addLog(@PathVariable Long propertyId,
                              @RequestBody String message) {
        return new ApiResponse(true, "Log added",
                service.addLog(propertyId, message));
    }

    @GetMapping("/{propertyId}")
    public ApiResponse getLogs(@PathVariable Long propertyId) {
        List<RatingLog> logs = service.getLogsByProperty(propertyId);
        return new ApiResponse(true, "Logs fetched", logs);
    }
}
