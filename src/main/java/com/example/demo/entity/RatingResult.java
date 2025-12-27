package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @PrePersist
    void onCreate() {
        ratedAt = LocalDateTime.now();
    }
}
