public interface RatingLogService {

    RatingLog addLog(Long userId,
                     Long propertyId,
                     Long ratingId,
                     Integer score);
}
