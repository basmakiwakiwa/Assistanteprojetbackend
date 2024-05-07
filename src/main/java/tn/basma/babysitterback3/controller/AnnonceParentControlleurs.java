package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.dto.AnnonceDeto;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.service.AnnonceParents;

import java.util.List;

@RequestMapping("/api/v1/parentAnnonce")

@RestController
public class AnnonceParentControlleurs {
    @Autowired

    AnnonceParents AnnonceParServ;


    // hthya methode mta3 methode ajoute annonce litab3a parent

    //LHNE bch namlou teste bch nchofo est ce que user etheke mawjoud ou nn
    @PostMapping(value ="/add/{id}")
    public AnnonceParent AjouteAnnonceParent(@PathVariable Long id , @RequestBody AnnonceDeto Annonce){

        return AnnonceParServ.AjouteAnnonceParent(id,Annonce);
    }



    //hthya methode get annonce
    @GetMapping("/affichelisteAnnonce")
    public List<AnnonceParent> getAllAnnonceParent()
    {
        return  AnnonceParServ.getAllAnnonce();
    }


    @PutMapping("/modifyByParentId/{idAnnonceParent}")
    public AnnonceParent modifierAnnonceParentByParentId( @PathVariable Long idAnnonceParent, @RequestBody AnnonceDeto newAnnonce) {
        System.out.println("id annonce "+idAnnonceParent);
        return AnnonceParServ.modifierAnnonceParentByParentId( idAnnonceParent, newAnnonce);
    }



    @DeleteMapping("/delete/{idAnnonceParent}")
    public void supprimerAnnonceParentById(@PathVariable Long idAnnonceParent) {
        AnnonceParServ.supprimerAnnonceParentById(idAnnonceParent);

    }








/*
    @DeleteMapping("/{idAnnonceParent}")
    public ResponseEntity<String> deleteAnnouncementForParentById(@PathVariable Long id, @PathVariable Long idAnnonceParent) {
        AnnonceParServ.deleteAnnouncementForParentById(id, idAnnonceParent);
        return ResponseEntity.ok("Announcement deleted successfully.");
    }

*/
}
