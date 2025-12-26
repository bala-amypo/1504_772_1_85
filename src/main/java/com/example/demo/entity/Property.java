package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private String city;   // ✅ REQUIRED for findByCity()

    private Double price;

    private Double areaSqFt;

    @ManyToMany
    private Set<User> assignedUsers;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAreaSqFt() {
        return areaSqFt;
    }

    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAreaSqFt(Double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    public void setAssignedUsers(Set<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }
}
