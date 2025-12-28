package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private String city;

    private Double price;

    private Double areaSqFt;

    // ---------------- ONE TO ONE ----------------

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private FacilityScore facilityScore;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private RatingResult ratingResult;

    // ---------------- ONE TO MANY ----------------

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    // ---------------- MANY TO MANY ----------------

    @ManyToMany(mappedBy = "assignedProperties")
    private Set<User> assignedUsers = new HashSet<>();

    // ---------------- HELPERS ----------------

    public void addRatingLog(RatingLog log) {
        ratingLogs.add(log);
        log.setProperty(this);
    }

    // ---------------- GETTERS & SETTERS ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAreaSqFt() {
        return areaSqFt;
    }

    public void setAreaSqFt(Double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    public FacilityScore getFacilityScore() {
        return facilityScore;
    }

    public void setFacilityScore(FacilityScore facilityScore) {
        this.facilityScore = facilityScore;
    }

    public RatingResult getRatingResult() {
        return ratingResult;
    }

    public void setRatingResult(RatingResult ratingResult) {
        this.ratingResult = ratingResult;
    }

    public List<RatingLog> getRatingLogs() {
        return ratingLogs;
    }

    public void setRatingLogs(List<RatingLog> ratingLogs) {
        this.ratingLogs = ratingLogs;
    }

    // 🔥 THIS METHOD WAS MISSING (CAUSE OF YOUR ERROR)
    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(Set<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }
}