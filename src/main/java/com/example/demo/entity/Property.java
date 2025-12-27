package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.util.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String city;

    @Min(0)
    private Double price;

    @Min(100)
    private Double areaSqFt;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private RatingResult ratingResult;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    @ManyToMany(mappedBy = "assignedProperties")
    private Set<User> assignedUsers = new HashSet<>();

    public Property() {}

    public void addRatingLog(RatingLog log) {
        ratingLogs.add(log);
        log.setProperty(this);
    }

    // GETTERS & SETTERS
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public Double getPrice() { return price; }
    public Double getAreaSqFt() { return areaSqFt; }
    public Set<User> getAssignedUsers() { return assignedUsers; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setPrice(Double price) { this.price = price; }
    public void setAreaSqFt(Double areaSqFt) { this.areaSqFt = areaSqFt; }
}
