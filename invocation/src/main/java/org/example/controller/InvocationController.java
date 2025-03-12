@RestController
@RequestMapping("/api/invocation")
public class InvocationController {

    @Autowired
    private InvocationService invocationService;
    @Autowired
    private InvocationLogRepository logRepository;

    // Endpoint pour invoquer un monstre
    @PostMapping
    public ResponseEntity<InvocationMonster> invokeMonster() {
        InvocationMonster monstre = invocationService.invokeMonster();
        return ResponseEntity.ok(monstre);
    }

    // Endpoint pour consulter les logs des invocations
    @GetMapping("/logs")
    public List<InvocationLog> getInvocationLogs() {
        return logRepository.findAll();
    }
}
