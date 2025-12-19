package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Property property;

    private Double finalRating;

    private String ratingCategory;

    private LocalDateTime ratedAt;

    // Default constructor
    public RatingResult() {
    }

    // Parameterized constructor
    public RatingResult(Property property, Double finalRating, String ratingCategory) {
        this.property = property;
        this.finalRating = finalRating;
        this.ratingCategory = ratingCategory;
    }

    @PrePersist
    public void onCreate() {
        this.ratedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Double getFinalRating() {
        return finalRating;
    }

    public void setFinalRating(Double finalRating) {
        this.finalRating = finalRating;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }

    public LocalDateTime getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(LocalDateTime ratedAt) {
        this.ratedAt = ratedAt;
    }
}
