@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Override
    public RatingLog addLog(Long userId,
                            Long propertyId,
                            Long ratingId,
                            Integer score) {

        RatingLog log = new RatingLog();
        log.setUserId(userId);
        log.setPropertyId(propertyId);
        log.setRatingId(ratingId);
        log.setScore(score);
        log.setCreatedAt(LocalDateTime.now());

        return ratingLogRepository.save(log);
    }
}
