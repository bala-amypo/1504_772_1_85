@RestController
@RequestMapping("/rating-log")
public class RatingLogController {

    @Autowired
    private RatingLogService ratingLogService;

    @PostMapping("/add")
    public ResponseEntity<RatingLog> addLog(
            @RequestParam Long userId,
            @RequestParam Long propertyId,
            @RequestParam Long ratingId,
            @RequestParam Integer score) {

        RatingLog log = ratingLogService.addLog(
                userId, propertyId, ratingId, score);

        return ResponseEntity.ok(log);
    }
}
