package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Competence;
import tn.basma.babysitterback3.service.CompetenceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/competences")
public class CompetenceController {

    @Autowired
    private  CompetenceService competenceService;

    @GetMapping("/all")
    public ResponseEntity<List<Competence>> getAllCompetences() {
        List<Competence> competences = competenceService.getAllCompetences();
        return ResponseEntity.ok(competences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getCompetenceById(@PathVariable Long id) {
        Optional<Competence> competence = competenceService.getCompetenceById(id);
        return competence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Competence> createCompetence(@RequestBody Competence competence) {
        Competence createdCompetence = competenceService.createCompetence(competence);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompetence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable Long id, @RequestBody Competence newCompetence) {
        Competence updatedCompetence = competenceService.updateCompetence(id, newCompetence);
        return updatedCompetence != null ?
                ResponseEntity.ok(updatedCompetence) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.noContent().build();
    }
}
