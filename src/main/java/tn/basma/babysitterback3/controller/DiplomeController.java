package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.service.DiplomeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diplomes")
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;

    // Endpoint to create a new diploma
    @PostMapping
    public Diplome createDiplome(@RequestBody Diplome diplome) {
        return diplomeService.createDiplome(diplome);
    }

    // Endpoint to retrieve a diploma by ID
    @GetMapping("/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable Long id) {
        Diplome diplome = diplomeService.getDiplomeById(id);
        if (diplome != null) {
            return ResponseEntity.ok(diplome);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to update an existing diploma
    @PutMapping("/{id}")
    public ResponseEntity<Diplome> updateDiplome(@PathVariable Long id, @RequestBody Diplome updatedDiplome) {
        updatedDiplome.setId(id); // Ensure the ID in the request body matches the path variable
        Diplome diplome = diplomeService.updateDiplome(updatedDiplome);
        if (diplome != null) {
            return ResponseEntity.ok(diplome);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a diploma by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiplome(@PathVariable Long id) {
        diplomeService.deleteDiplome(id);
        return ResponseEntity.noContent().build();
    }

    // Other endpoints as needed...

    // Endpoint to get all diplomas
    @GetMapping
    public List<Diplome> getAllDiplomes() {
        return diplomeService.getAllDiplomes();
    }



}
