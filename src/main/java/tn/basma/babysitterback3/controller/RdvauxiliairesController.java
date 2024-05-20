package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Rdvauxiliaires;
import tn.basma.babysitterback3.service.RdvauxiliairesServiceImpl;

@RequestMapping("/api/v1/rdvauxiliaires")
@RestController
public class RdvauxiliairesController {

    @Autowired
    private RdvauxiliairesServiceImpl rdvService;

    @PostMapping("/add/{id}/{auxiliairesdevie_id}")
    public ResponseEntity<Rdvauxiliaires> addRdvWithParent(@PathVariable Long id, @PathVariable Long auxiliairesdevie_id, @RequestBody Rdvauxiliaires rdv) {
        Rdvauxiliaires savedRdv = rdvService.saveRdvWithauxiliairesdevie(id, auxiliairesdevie_id, rdv);
        if (savedRdv != null) {
            return new ResponseEntity<>(savedRdv, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}