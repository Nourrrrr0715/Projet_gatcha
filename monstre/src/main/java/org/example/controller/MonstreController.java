package org.example.controller;

import org.example.model.Monstre;
import org.example.service.MonstreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monstres")
public class MonstreController {

    private final MonstreService monstreService;

    public MonstreController(MonstreService monstreService) {
        this.monstreService = monstreService;
    }

    @GetMapping
    public ResponseEntity<List<Monstre>> getAllMonstres() {
        List<Monstre> monstres = monstreService.getAllMonstres();
        return ResponseEntity.ok(monstres);
    }

    @PostMapping
    public ResponseEntity<Monstre> ajouterMonstre(@RequestBody Monstre monstre) {
        Monstre nouveauMonstre = monstreService.ajouterMonstre(monstre);
        return ResponseEntity.ok(nouveauMonstre);
    }
}
