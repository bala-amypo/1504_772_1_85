public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByCity(String city);

    @Query("FROM Property p WHERE p.city = :city")
    List<Property> findByCityHql(@Param("city") String city);
}
