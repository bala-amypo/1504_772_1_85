package com.example.demo.service;

import com.example.demo.entity.Property;

import java.util.List;

public interface PropertyService {
    Property save(Property property);
    List<Property> findAll();
}
