package com.example.joueur.service;

import com.example.joueur.model.Joueur;
import com.example.joueur.repository.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public Joueur createJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public Joueur getJoueurById(String id) {
        return joueurRepository.findById(id).orElse(null);
    }

    public List<Joueur> getAllJoueur() {
        return joueurRepository.findAll();
    }

    public void deleteJoueur(String id) {
        joueurRepository.delete(getJoueurById(id));
    }

    public void deleteAllJoueurs() {
        joueurRepository.deleteAll();
    }

    public Joueur updateJoueur(String id, Joueur joueurDetails) {
        return joueurRepository.findById(id).map(joueur -> {
            joueur.setLevel(joueurDetails.getLevel());
            joueur.setExperience(joueurDetails.getExperience());
            joueur.setMonstres(joueurDetails.getMonstres());

            return joueurRepository.save(joueur);
        }).orElseThrow(() -> new RuntimeException("Joueur non trouvé avec l'ID : " + id));
    }



}
