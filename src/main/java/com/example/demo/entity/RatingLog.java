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

    @ManyToOne
    private User user;

    private Integer rating;

    private LocalDateTime loggedAt;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public User getUser() {
        return user;
    }

    public Integer getRating() {
        return rating;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    // ===== SETTERS (THIS FIXES YOUR ERROR) =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
