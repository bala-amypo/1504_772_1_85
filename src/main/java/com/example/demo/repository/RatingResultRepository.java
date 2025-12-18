public interface RatingResultRepository extends JpaRepository<RatingResult, Long> {
    Optional<RatingResult> findByPropertyId(Long propertyId);
}
