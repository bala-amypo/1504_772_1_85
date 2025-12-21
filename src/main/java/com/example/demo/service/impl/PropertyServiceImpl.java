package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository repo;

    public PropertyServiceImpl(PropertyRepository repo) {
        this.repo = repo;
    }

    @Override
    public Property addProperty(Property property) {
        if (property.getPrice() < 0 || property.getAreaSqFt() < 100) {
            throw new IllegalArgumentException("Invalid property data");
        }
        return repo.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return repo.findAll();
    }
}
