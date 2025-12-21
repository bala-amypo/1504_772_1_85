package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FacilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    @OneToOne
    private Property property;

    public Long getId() { return id; }
    public int getScore() { return score; }
    public Property getProperty() { return property; }

    public void setScore(int score) { this.score = score; }
    public void setProperty(Property property) { this.property = property; }
}
