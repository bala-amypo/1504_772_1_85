package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_logs")
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    private String message;
    private LocalDateTime loggedAt;

    public RatingLog() {}

    @PrePersist
    void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Property getProperty() { return property; }
    public String getMessage() { return message; }

    public void setProperty(Property property) { this.property = property; }
    public void setMessage(String message) { this.message = message; }
}
