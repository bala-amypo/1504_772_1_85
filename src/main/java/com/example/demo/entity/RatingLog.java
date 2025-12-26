package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Property property;

    private String message;

    // ✅ REQUIRED: Default constructor
    public RatingLog() {
    }

    // ✅ REQUIRED: Constructor used by tests
    public RatingLog(Property property) {
        this.property = property;
    }

    // ✅ REQUIRED: Constructor used by tests
    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
