package com.example.demo.controller;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // ------------------------------
    // ADMIN only → CREATE
    // ------------------------------
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Property> create(@Valid @RequestBody Property property) {
        Property saved = propertyRepository.save(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ------------------------------
    // AUTHENTICATED users → LIST
    // ------------------------------
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    public ResponseEntity<List<Property>> list() {
        return ResponseEntity.ok(propertyRepository.findAll());
    }
}
