# README – Projet Gatcha APIs

Ce document décrit comment mettre en place et exécuter un ensemble d’API pour un jeu de type Gacha (ou Gatcha), conformément aux spécifications énoncées dans le fichier **Gatcha APIs (1).pdf**.

---

## 1. Présentation du Projet

Le projet vise à créer plusieurs microservices pour gérer :

1. **API d’authentification**  
   - Gérer la création et la validation d’un token pour authentifier les utilisateurs.  
   - Stocker en base les identifiants/mots de passe et la date d’expiration du token.  
   - Valider ou refuser les appels aux autres API selon la validité du token.

2. **API Joueur**  
   - Gérer les comptes joueurs, leurs niveaux, leur expérience et la liste de leurs monstres.  
   - Permettre de gagner de l’expérience, de monter en niveau, d’ajouter ou de retirer un monstre.

3. **API Monstres**  
   - Gérer les monstres (stats, compétences, points d’XP, etc.).  
   - Permettre d’augmenter leur niveau et leurs compétences, en lien avec le joueur.

4. **API d’Invocations**  
   - Générer aléatoirement un monstre en se basant sur une base de données de « monstres de base » et leur probabilité d’invocation.  
   - Transmettre ensuite l’ID du monstre créé à l’API Joueur.  
   - Stocker localement un log d’invocation pour rejouer les invocations en cas de problème réseau.

5. **(Bonus) API Combat**  
   - Simuler un combat automatique entre deux monstres.  
   - Retourner le vainqueur et l’historique de combat.

**Objectif** : Toutes ces API doivent être dockerisées et orchestrées via **docker-compose** pour qu’un utilisateur puisse récupérer le code, lancer une seule commande et avoir l’ensemble des services opérationnels, y compris les bases de données (MongoDB).

---

## 2. Prérequis

- **Docker** et **docker-compose** installés sur la machine hôte.  
- **Java 17** (ou version compatible avec Spring Boot) si vous souhaitez compiler manuellement (facultatif si tout est déjà containerisé).  
- **Maven** (optionnel, si vous voulez recompiler en local).

---

## 3. Architecture Globale

Le projet se compose de plusieurs conteneurs Docker :

1. **auth-api** : Service Spring Boot pour l’API d’authentification.  
2. **player-api** : Service Spring Boot pour l’API Joueur.  
3. **monsters-api** : Service Spring Boot pour l’API Monstres.  
4. **invocation-api** : Service Spring Boot pour l’API d’Invocations.  
5. **combat-api** (optionnel) : Service Spring Boot pour l’API Combat.  
6. **mongodb-xxx** : Conteneurs MongoDB pour stocker les données de chaque API (auth, player, monsters, invocation, etc.).

**docker-compose** se charge de lancer tous ces conteneurs simultanément et de configurer les liens réseaux entre eux.

---

## 4. Mise en Place et Lancement

### 4.1 Récupération du Projet

1. **Cloner** ou télécharger le dépôt Git contenant le code :  
   ```bash
   git clone https://votre-repo.git
   cd gatcha-apis
