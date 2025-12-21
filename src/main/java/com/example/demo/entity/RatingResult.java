package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double finalRating;
    private String ratingCategory;

    @ManyToOne
    private Property property;

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setFinalRating(double finalRating) {
        this.finalRating = finalRating;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }
}
