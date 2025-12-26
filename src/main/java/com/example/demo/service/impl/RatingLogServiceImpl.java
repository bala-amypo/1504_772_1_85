@Service
public class RatingLogServiceImpl implements RatingLogService {

    @Autowired
    private RatingLogRepository ratingLogRepository;

    @Override
    public RatingLog addLog(Long propertyId, String message) {
        RatingLog log = new RatingLog();
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        Property property = new Property();
        property.setId(propertyId);
        log.setProperty(property);

        return ratingLogRepository.save(log);
    }

    @Override
    public RatingLog addLog(Property property, String message) {
        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        return ratingLogRepository.save(log);
    }

    @Override
    public RatingLog addLog(Property property, User user, String message) {
        RatingLog log = new RatingLog();
        log.setProperty(property);
        log.setUser(user);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        return ratingLogRepository.save(log);
    }

    @Override
    public List<RatingLog> findByPropertyId(Long propertyId) {
        return ratingLogRepository.findByPropertyId(propertyId);
    }
}
