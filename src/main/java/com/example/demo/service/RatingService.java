public interface RatingService {
    RatingResult generateRating(Long propertyId);
    RatingResult getRating(Long propertyId);
}
