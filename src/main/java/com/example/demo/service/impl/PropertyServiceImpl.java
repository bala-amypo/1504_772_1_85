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

    public Property save(Property property) {
        return repo.save(property);
    }

    public List<Property> findAll() {
        return repo.findAll();
    }
}
