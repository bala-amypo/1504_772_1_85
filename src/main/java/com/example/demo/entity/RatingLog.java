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

    public RatingLog() {
        this.loggedAt = LocalDateTime.now();
    }

    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
        this.loggedAt = LocalDateTime.now();
    }

    /* ===== REQUIRED BY TEST ===== */
    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    /* ===== getters & setters ===== */

    public void setProperty(Property property) {
        this.property = property;
    }
}
