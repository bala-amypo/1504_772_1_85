@RestController
@RequestMapping("/ratings")
@Tag(name = "Ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/generate/{propertyId}")
    @Operation(summary = "Generate rating")
    public RatingResult generateRating(@PathVariable Long propertyId) {
        return ratingService.generateRating(propertyId);
    }

    @GetMapping("/property/{propertyId}")
    @Operation(summary = "Get rating result")
    public RatingResult getRating(@PathVariable Long propertyId) {
        return ratingService.getRating(propertyId);
    }
}
