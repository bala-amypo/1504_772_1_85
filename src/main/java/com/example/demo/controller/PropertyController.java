package com.example.demo.controller;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.service.FacilityScoreService;
import com.example.demo.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;
    private final FacilityScoreService scoreService;

    public PropertyController(PropertyService propertyService,
                              FacilityScoreService scoreService) {
        this.propertyService = propertyService;
        this.scoreService = scoreService;
    }

    @PostMapping
    public Property create(@RequestBody Property property) {
        return propertyService.save(property);
    }

    @GetMapping
    public List<Property> getAll() {
        return propertyService.findAll();
    }

    @PostMapping("/{id}/score")
    public FacilityScore calculateScore(@PathVariable Long id) {
        return scoreService.calculateScore(id);
    }
}
