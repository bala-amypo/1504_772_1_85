package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String address;
    private String city;

    @Min(1)
    private Double price;

    @Min(100)
    private Double areaSqFt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<RatingLog> ratingLogs;

    // Default constructor
    public Property() {
    }

    // Parameterized constructor
    public Property(String title, String address, String city, Double price, Double areaSqFt, List<RatingLog> ratingLogs) {
        this.title = title;
        this.address = address;
        this.city = city;
        this.price = price;
        this.areaSqFt = areaSqFt;
        this.ratingLogs = ratingLogs;
    }

    // Getter and Setter methods

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

    public List<RatingLog> getRatingLogs() {
        return ratingLogs;
    }

    public void setRatingLogs(List<RatingLog> ratingLogs) {
        this.ratingLogs = ratingLogs;
    }
}
