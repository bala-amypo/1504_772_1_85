package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating_results")
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    // ✅ REQUIRED: No-arg constructor
    public RatingResult() {
    }

    // ✅ GETTERS & SETTERS (VERY IMPORTANT)

    public Long getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
