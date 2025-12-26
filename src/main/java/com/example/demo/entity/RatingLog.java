package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Property property;

    private String message;

    private LocalDateTime loggedAt;

    // 🔹 REQUIRED constructors
    public RatingLog() {}

    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
        this.loggedAt = LocalDateTime.now();
    }

    // 🔹 REQUIRED getters
    public Long getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}
