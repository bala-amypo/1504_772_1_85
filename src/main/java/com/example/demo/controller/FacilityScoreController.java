@RestController
@RequestMapping("/scores")
@Tag(name = "Facility Scores")
public class FacilityScoreController {

    private final FacilityScoreService facilityScoreService;

    public FacilityScoreController(FacilityScoreService facilityScoreService) {
        this.facilityScoreService = facilityScoreService;
    }

    @PostMapping("/{propertyId}")
    @Operation(summary = "Submit facility score")
    public FacilityScore addScore(@PathVariable Long propertyId,
                                  @RequestBody FacilityScore score) {
        return facilityScoreService.addScore(propertyId, score);
    }

    @GetMapping("/{propertyId}")
    @Operation(summary = "Get facility score by property")
    public FacilityScore getScore(@PathVariable Long propertyId) {
        return facilityScoreService.getScoreByProperty(propertyId);
    }
}
