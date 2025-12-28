package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingResultRepository ratingResultRepository;
    private final PropertyRepository propertyRepository;

    public RatingService(FacilityScoreRepository fsRepo,
                         RatingResultRepository rrRepo,
                         PropertyRepository propRepo) {
        this.facilityScoreRepository = fsRepo;
        this.ratingResultRepository = rrRepo;
        this.propertyRepository = propRepo;
    }

    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId).orElseThrow();
        FacilityScore fs = facilityScoreRepository.findByProperty(property).orElseThrow();

        double avg = (fs.getSchoolProximity()
                + fs.getHospitalProximity()
                + fs.getTransportAccess()
                + fs.getSafetyScore()) / 4.0;

        RatingResult rr = new RatingResult();
        rr.setProperty(property);
        rr.setFinalRating(avg);

        if (avg >= 8) rr.setRatingCategory("EXCELLENT");
        else if (avg >= 6) rr.setRatingCategory("GOOD");
        else if (avg >= 4) rr.setRatingCategory("AVERAGE");
        else rr.setRatingCategory("POOR");

        return ratingResultRepository.save(rr);
    }
}
