package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FacilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int schoolProximity;
    private int hospitalProximity;
    private int transportAccess;
    private int safetyScore;

    @ManyToOne
    private Property property;

    public int getSchoolProximity() { return schoolProximity; }
    public int getHospitalProximity() { return hospitalProximity; }
    public int getTransportAccess() { return transportAccess; }
    public int getSafetyScore() { return safetyScore; }

    public void setProperty(Property property) {
        this.property = property;
    }
}
