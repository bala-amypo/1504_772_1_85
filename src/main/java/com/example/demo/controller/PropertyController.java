package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse addProperty(@RequestBody Property property) {
        return new ApiResponse(true, "Property added",
                service.addProperty(property));
    }

    @GetMapping
    public ApiResponse getAllProperties() {
        List<Property> properties = service.getAllProperties();
        return new ApiResponse(true, "Property list", properties);
    }
}
