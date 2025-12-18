public interface RatingLogService {
    RatingLog addLog(Long propertyId, String message);
    List<RatingLog> getLogsByProperty(Long propertyId);
}
