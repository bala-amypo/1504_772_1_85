package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int rooms;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getRooms() { return rooms; }

    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setRooms(int rooms) { this.rooms = rooms; }
}
