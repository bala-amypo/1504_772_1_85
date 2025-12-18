@RestController
@RequestMapping("/logs")
@Tag(name = "Rating Logs")
public class RatingLogController {

    private final RatingLogService ratingLogService;

    public RatingLogController(RatingLogService ratingLogService) {
        this.ratingLogService = ratingLogService;
    }

    @PostMapping("/{propertyId}")
    @Operation(summary = "Add rating log")
    public RatingLog addLog(@PathVariable Long propertyId,
                            @RequestParam String message) {
        return ratingLogService.addLog(propertyId, message);
    }

    @GetMapping("/property/{propertyId}")
    @Operation(summary = "Get logs by property")
    public List<RatingLog> getLogs(@PathVariable Long propertyId) {
        return ratingLogService.getLogsByProperty(propertyId);
    }
}
