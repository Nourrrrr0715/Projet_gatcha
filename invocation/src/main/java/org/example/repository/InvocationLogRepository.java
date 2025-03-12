package com.example.monsterapp.repository;

import com.example.monsterapp.model.InvocationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvocationLogRepository extends MongoRepository<InvocationLog, String> {
    // Vous pouvez ajouter ici des méthodes de requête personnalisées si besoin
}
