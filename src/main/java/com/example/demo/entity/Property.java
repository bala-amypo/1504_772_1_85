package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private double areaSqFt;

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getAreaSqFt() {
        return areaSqFt;
    }
}
