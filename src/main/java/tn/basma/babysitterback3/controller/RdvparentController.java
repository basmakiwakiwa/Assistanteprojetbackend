package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.RdvParent;
import tn.basma.babysitterback3.service.RdvparentService;

import java.util.List;

@RequestMapping("/api/v1/rdvparent")

@RestController
public class RdvparentController {

    @Autowired
    private RdvparentService rdvService;


    @PostMapping("/add/{id}/{idauxiliaires}")
    public ResponseEntity<RdvParent> addRdvWithParent(@PathVariable Long id, @PathVariable Long idauxiliaires, @RequestBody RdvParent rdv) {
        RdvParent savedRdv = rdvService.saveRdvWithParent(id,idauxiliaires, rdv);
        if (savedRdv != null) {
            return new ResponseEntity<>(savedRdv, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }










//liste hthya yjibli liste lkoul mta3 rdv par id paernt
    @GetMapping("/all/{id}")
    public ResponseEntity<List<RdvParent>> getAllRdvsByParentId(@PathVariable Long id) {
        List<RdvParent> rdvs = rdvService.getAllRdvsByParentId(id);
        return new ResponseEntity<>(rdvs, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{rdvId}")
    public ResponseEntity<String> deleteRdv(@PathVariable Long rdvId) {
        boolean deleted = rdvService.deleteRdv(rdvId);
        if (deleted) {
            return new ResponseEntity<>("Rdv deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Rdv not found or could not be deleted", HttpStatus.NOT_FOUND);
    }




    @PutMapping("/update/{rdvId}")
    public ResponseEntity<RdvParent> updateRdv(@PathVariable Long rdvId, @RequestBody RdvParent rdvDetails) {
        RdvParent updatedRdv = rdvService.updateRdv(rdvId, rdvDetails);
        if (updatedRdv != null) {
            return new ResponseEntity<>(updatedRdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }





    @GetMapping("/RDVauxiliaire/{auxiliaireId}")
    public ResponseEntity<List<RdvParent>> getRdvByAuxiliaireId(@PathVariable Long auxiliaireId) {
        List<RdvParent> rdvs = rdvService.getRdvByAuxiliaireId(auxiliaireId);
        return ResponseEntity.ok(rdvs);
    }




//hthya methode accepte
    @PutMapping("/accepter/{id}")
    public ResponseEntity<RdvParent> accepterRdv(@PathVariable("id") Long id) {
        RdvParent rdv = rdvService.accepterRdv(id);
        return ResponseEntity.ok(rdv);
    }

//hthya methode non accepte
    @PutMapping("/NonAccepte/{id}")
    public ResponseEntity<RdvParent> refuserRdv(@PathVariable("id") Long id) {
        RdvParent rdv = rdvService.refuserRdv(id);
        return ResponseEntity.ok(rdv);
    }

//hthye methode en attente
    @PutMapping("/EnAttente/{id}")
    public ResponseEntity<RdvParent> mettreEnAttenteRdv(@PathVariable("id") Long id) {
        RdvParent rdv = rdvService.mettreEnAttenteRdv(id);
        return ResponseEntity.ok(rdv);
    }

}
