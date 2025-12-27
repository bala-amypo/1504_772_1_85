package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_results")
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    private Double finalRating;
    private String ratingCategory;

    private LocalDateTime ratedAt;

    public RatingResult() {}

    @PrePersist
    void onCreate() {
        ratedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Property getProperty() { return property; }
    public Double getFinalRating() { return finalRating; }
    public String getRatingCategory() { return ratingCategory; }

    public void setProperty(Property property) { this.property = property; }
    public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }
}
