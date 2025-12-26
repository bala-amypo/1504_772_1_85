package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    // ✅ REQUIRED BY TEST
    public void addRatingLog(RatingLog log) {
        log.setProperty(this);
        this.ratingLogs.add(log);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
