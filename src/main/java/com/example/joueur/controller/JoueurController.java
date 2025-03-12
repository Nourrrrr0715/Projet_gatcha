package com.example.joueur.controller;

import com.example.joueur.model.Joueur;
import com.example.joueur.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping
    public List<Joueur> getAllJoueur() {
        return joueurService.getAllJoueur();
    }

    @GetMapping("/{id}")
    public Joueur getJoueur(@PathVariable String id) {
        return joueurService.getJoueurById(id);
    }
    

    @PostMapping
    public Joueur createJoueur(@RequestBody Joueur joueur) {
        return joueurService.createJoueur(joueur);
    }

    @DeleteMapping("/{id}")
    public void deleteJoueur(@PathVariable String id) {
        joueurService.deleteJoueur(id);
    }

    @DeleteMapping
    public void deleteAllJoueurs() {
        joueurService.deleteAllJoueurs();
    }

    @PatchMapping("/{id}")
    public Joueur updateJoueur(@PathVariable String id, @RequestBody Joueur joueur) {
        return joueurService.updateJoueur(id, joueur);
    }
}

