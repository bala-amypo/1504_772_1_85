package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;
    private Double areaSqFt;
    private String city;

    @ElementCollection
    private List<String> assignedUsers;

    // 🔹 REQUIRED getters for tests
    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAreaSqFt() {
        return areaSqFt;
    }

    public String getCity() {
        return city;
    }

    public List<String> getAssignedUsers() {
        return assignedUsers;
    }

    // 🔹 setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAreaSqFt(Double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAssignedUsers(List<String> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }
}
