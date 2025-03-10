package com.example.joueur.repository;

import com.example.joueur.model.Joueur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends MongoRepository<Joueur, String> {
}
