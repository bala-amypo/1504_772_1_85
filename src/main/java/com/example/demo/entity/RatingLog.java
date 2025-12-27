package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    private String message;

    private LocalDateTime loggedAt;

    @PrePersist
    void onCreate() {
        loggedAt = LocalDateTime.now();
    }
}
