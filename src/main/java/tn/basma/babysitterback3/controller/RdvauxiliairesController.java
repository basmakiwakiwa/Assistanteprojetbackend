package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Rdvauxiliaires;
import tn.basma.babysitterback3.service.RdvauxiliairesServiceImpl;

import java.util.List;

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


    @GetMapping("/byauxiliaire/{id}")
    public ResponseEntity<List<Rdvauxiliaires>> getRdvByAuxiliaireId(@PathVariable Long id) {
        List<Rdvauxiliaires> rdvauxiliaires = rdvService.getRdvByAuxiliaireId(id);
        if (rdvauxiliaires != null && !rdvauxiliaires.isEmpty()) {
            return new ResponseEntity<>(rdvauxiliaires, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRdvauxiliairesById(@PathVariable("id") Long id) {
        rdvService.deleteRdvauxiliairesById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Rendez-vous avec l'ID " + id + " a été supprimé avec succès.");
    }


    @PutMapping("/update/{rdvId}")
    public ResponseEntity<Rdvauxiliaires> updateRdv(@PathVariable Long rdvId, @RequestBody Rdvauxiliaires rdvDetails) {
        Rdvauxiliaires updatedRdv = rdvService.updateRdv(rdvId, rdvDetails);
        if (updatedRdv != null) {
            return new ResponseEntity<>(updatedRdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping("/byparent/{parentId}")
    public List<Rdvauxiliaires> getRdvByParentId(@PathVariable Long parentId) {
        return rdvService.getRdvByParentId(parentId);
    }



    @PutMapping("/accepterRdvauxiliaires/{id}")
    public ResponseEntity< Rdvauxiliaires> accepterRdv(@PathVariable("id") Long id) {
        Rdvauxiliaires rdv = rdvService.accepterRdv(id);
        return ResponseEntity.ok(rdv);
    }

    @PutMapping("/NonAccepteRdvauxiliaires/{id}")
    public ResponseEntity<Rdvauxiliaires> refuserRdv(@PathVariable("id") Long id) {
        Rdvauxiliaires rdv = rdvService.refuserRdv(id);
        return ResponseEntity.ok(rdv);
    }


    @PutMapping("/EnAttenteRdvauxiliaires/{id}")
    public ResponseEntity<Rdvauxiliaires> mettreEnAttenteRdv(@PathVariable("id") Long id) {
        Rdvauxiliaires rdv = rdvService.mettreEnAttenteRdv(id);
        return ResponseEntity.ok(rdv);
    }

}