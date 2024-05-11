package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Rdv;
import tn.basma.babysitterback3.service.RdvService;

import java.util.List;

@RequestMapping("/api/v1/rdvparent")

@RestController
public class RdvController {

    @Autowired
    private RdvService rdvService;

    @PostMapping("/add/{id}/{idauxiliaires}")
    public ResponseEntity<Rdv> addRdvWithParent(@PathVariable Long id,@PathVariable Long idauxiliaires, @RequestBody Rdv rdv) {
        Rdv savedRdv = rdvService.saveRdvWithParent(id,idauxiliaires, rdv);
        if (savedRdv != null) {
            return new ResponseEntity<>(savedRdv, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/all/{id}")
    public ResponseEntity<List<Rdv>> getAllRdvsByParentId(@PathVariable Long id) {
        List<Rdv> rdvs = rdvService.getAllRdvsByParentId(id);
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



}
