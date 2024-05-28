package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.dispo;
import tn.basma.babysitterback3.service.DispoService;

import java.util.List;

@RequestMapping("/api/v1/Dispo")

@RestController
public class DispoController {
    @Autowired
    DispoService dispoService;


    @PostMapping("/auxiliaire/{auxiliaireId}")
    public ResponseEntity<dispo> addDispoToAuxiliaire(@PathVariable Long auxiliaireId, @RequestBody dispo newDispo) {
        dispo createdDispo = dispoService.addDispoToAuxiliaire(auxiliaireId, newDispo);
        return ResponseEntity.ok(createdDispo);
    }

    @GetMapping("/AfficheDispoauxiliaire/{auxiliaireId}")
    public ResponseEntity<List<dispo>> getDisposByAuxiliaireId(@PathVariable Long auxiliaireId) {
        List<dispo> dispos = dispoService.getDisposByAuxiliaireId(auxiliaireId);
        return ResponseEntity.ok(dispos);
    }
}