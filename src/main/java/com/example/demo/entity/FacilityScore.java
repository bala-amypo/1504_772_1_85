package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class FacilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Property property;

    @Max(10) @Min(0)
    private Integer schoolProximity;

    @Max(10) @Min(0)
    private Integer hospitalProximity;

    @Max(10) @Min(0)
    private Integer transportAccess;

    @Max(10) @Min(0)
    private Integer safetyScore;

    public FacilityScore() {
    }

    public FacilityScore(Property property, Integer schoolProximity, Integer hospitalProximity,
                         Integer transportAccess, Integer safetyScore) {
        this.property = property;
        this.schoolProximity = schoolProximity;
        this.hospitalProximity = hospitalProximity;
        this.transportAccess = transportAccess;
        this.safetyScore = safetyScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getSchoolProximity() {
        return schoolProximity;
    }

    public void setSchoolProximity(Integer schoolProximity) {
        this.schoolProximity = schoolProximity;
    }

    public Integer getHospitalProximity() {
        return hospitalProximity;
    }

    public void setHospitalProximity(Integer hospitalProximity) {
        this.hospitalProximity = hospitalProximity;
    }

    public Integer getTransportAccess() {
        return transportAccess;
    }

    public void setTransportAccess(Integer transportAccess) {
        this.transportAccess = transportAccess;
    }

    public Integer getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(Integer safetyScore) {
        this.safetyScore = safetyScore;
    }
}
