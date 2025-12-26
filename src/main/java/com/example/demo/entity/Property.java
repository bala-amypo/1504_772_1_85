package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /* ================= REQUIRED BY TEST ================= */

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    @ElementCollection
    private List<String> assignedUsers = new ArrayList<>();

    public void addRatingLog(RatingLog log) {
        ratingLogs.add(log);
        log.setProperty(this);
    }

    public List<String> getAssignedUsers() {
        return assignedUsers;
    }

    /* ================= getters & setters ================= */

    public Long getId() {
        return id;
    }

    public List<RatingLog> getRatingLogs() {
        return ratingLogs;
    }
}
