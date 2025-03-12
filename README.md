Le projet vise à créer plusieurs microservices pour gérer :

API d’authentification

Gérer la création et la validation d’un token pour authentifier les utilisateurs.
Stocker en base les identifiants/mots de passe et la date d’expiration du token.
Valider ou refuser les appels aux autres API selon la validité du token.
API Joueur

Gérer les comptes joueurs, leurs niveaux, leur expérience et la liste de leurs monstres.
Permettre de gagner de l’expérience, de monter en niveau, d’ajouter ou de retirer un monstre.
API Monstres

Gérer les monstres (stats, compétences, points d’XP, etc.).
Permettre d’augmenter leur niveau et leurs compétences, en lien avec le joueur.
API d’Invocations

Générer aléatoirement un monstre en se basant sur une base de données de « monstres de base » et leur probabilité d’invocation.
Transmettre ensuite l’ID du monstre créé à l’API Joueur.
Stocker localement un log d’invocation (base « tampon ») permettant de rejouer les invocations en cas de problème réseau.
(Bonus) API Combat

Simuler un combat automatique entre deux monstres (entrée : 2 monstres, sortie : vainqueur, logs de combat).
Objectif : Toutes ces API doivent être dockerisées et orchestrées via docker-compose pour qu’un utilisateur puisse récupérer le code, lancer une seule commande et avoir l’ensemble des services opérationnels, y compris les bases de données (MongoDB).
