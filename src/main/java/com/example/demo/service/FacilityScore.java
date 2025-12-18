public interface FacilityScoreService {
    FacilityScore addScore(Long propertyId, FacilityScore score);
    FacilityScore getScoreByProperty(Long propertyId);
}
