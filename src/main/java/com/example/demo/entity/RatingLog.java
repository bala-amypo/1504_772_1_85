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

    // 🔹 REQUIRED no-arg constructor
    public RatingLog() {}

    // 🔹 OPTIONAL constructor
    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
        this.loggedAt = LocalDateTime.now();
    }

    // 🔹 GETTERS
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

    // 🔹 SETTERS (TESTS REQUIRE THESE)
    public void setProperty(Property property) {
        this.property = property;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
