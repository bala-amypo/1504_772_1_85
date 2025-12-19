@RestController
@RequestMapping("/properties")
@Tag(name = "Property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    @Operation(summary = "Add new property")
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @GetMapping
    @Operation(summary = "List all properties")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }
}
