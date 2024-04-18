package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.service.DiplomeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/diplomes")
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;


    @GetMapping("/all")
    public ResponseEntity<List<Diplome>> getAllDiplomes() {
        List<Diplome> diplomes = diplomeService.getAllDiplome();
        return new ResponseEntity<>(diplomes, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable("id") Long id) {
        Optional<Diplome> activity = diplomeService.getDiplomeById(id);
        return activity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        Diplome createdDiplome = diplomeService.createDiplome(diplome);
        return new ResponseEntity<>(createdDiplome, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diplome> updateActivity(@PathVariable("id") Long id, @RequestBody Diplome diplome) {
        Diplome updatedDiplome = diplomeService.updateDiplome(id, diplome);
        return updatedDiplome != null ?
                new ResponseEntity<>(updatedDiplome, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiplome(@PathVariable("id") Long id) {
        diplomeService.deleteDiplome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
