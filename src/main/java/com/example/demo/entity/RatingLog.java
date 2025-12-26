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

    @ManyToOne
    private Rating rating;

    private Integer score;

    private LocalDateTime loggedAt;

    // getters and setters
}
