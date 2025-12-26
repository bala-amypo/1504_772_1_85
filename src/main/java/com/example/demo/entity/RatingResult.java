package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double finalRating;

    private String ratingCategory;

    private LocalDateTime ratedAt;

    @ManyToOne
    private Property property;

    // ✅ REQUIRED BY TEST
    public double getFinalRating() {
        return finalRating;
    }

    // ✅ REQUIRED BY TEST
    public void setFinalRating(double finalRating) {
        this.finalRating = finalRating;
    }

    // ✅ REQUIRED BY TEST
    public String getRatingCategory() {
        return ratingCategory;
    }

    // ✅ REQUIRED BY TEST
    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }

    // ✅ REQUIRED BY TEST
    public LocalDateTime getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(LocalDateTime ratedAt) {
        this.ratedAt = ratedAt;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
