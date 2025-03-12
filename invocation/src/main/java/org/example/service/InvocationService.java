@Service
public class InvocationService {

    // Liste statique des monstres disponibles à l'invocation
    private static final List<InvocationMonster> MONSTRES_DISPONIBLES = List.of(
            new InvocationMonster(1L, "Dragon Rouge", "Feu", 1200, 300, 200, 150, 5.0),
            new InvocationMonster(2L, "Serpent Marin", "Eau", 900, 250, 100, 180, 15.0),
            new InvocationMonster(3L, "Golem de Pierre", "Vent", 1500, 200, 300, 50, 10.0),
            // ... autres monstres avec leurs stats et taux d'invocation
    );

    @Autowired
    private InvocationLogRepository logRepository;

    public InvocationMonster invokeMonster() {
        InvocationMonster monstre = tirerMonstreAleatoire();
        // Enregistrer le résultat de l'invocation dans les logs
        InvocationLog log = new InvocationLog(monstre);
        logRepository.save(log);
        return monstre;
    }

    private InvocationMonster tirerMonstreAleatoire() {
        // Calcul de l'invocation pondérée par les taux d'invocation
        double totalTaux = MONSTRES_DISPONIBLES.stream()
                .mapToDouble(m -> m.getTauxInvocation())
                .sum();
        double tirage = Math.random() * totalTaux;
        double cumul = 0.0;
        for (InvocationMonster m : MONSTRES_DISPONIBLES) {
            cumul += m.getTauxInvocation();
            if (tirage <= cumul) {
                return m;
            }
        }
        // Par sécurité (ne devrait pas arriver si les taux sont bien définis)
        return MONSTRES_DISPONIBLES.get(0);
    }
}
