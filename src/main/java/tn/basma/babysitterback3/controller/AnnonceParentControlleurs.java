package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.service.AnnonceParents;

import java.util.List;

@RequestMapping("/parentAnnonce")

@RestController
public class AnnonceParentControlleurs {
    @Autowired
    AnnonceParents AnnonceParServ;

    // hthya methode mta3 methode ajoute annonce litab3a parent

    @PostMapping(value ="/add")
    public AnnonceParent AjouteAnnonceParent(@RequestBody AnnonceParent Annonce){

        return AnnonceParServ.createAnnonceParent(Annonce);
    }


    //hthya methode modifier par exemple nhb naml modif 3al annonnce eli 3maltha donnc hthya hya methode
    @PutMapping("/update/{idAnnonceParent}")
    public AnnonceParent updateAnnonce (@PathVariable Long idAnnonceParent , @RequestBody AnnonceParent Annonce)
    {
        return AnnonceParServ.updateAnnonce(idAnnonceParent, Annonce);
    }


    //hthya methode supprimer Annonce mta3 parent

    @DeleteMapping(value="/deleteAnnonce/{idAnnonceParent}")
    public void deleteAnnonce(@PathVariable Long idAnnonceParent)
    {
        AnnonceParServ.deleteAnnonce(idAnnonceParent);
    }

    //hthya bch tafichiliannonce eli a3mlthom el koul

    @GetMapping("/afficheAnnonce")
    public List<AnnonceParent> getAllPosts()
    {
        return AnnonceParServ.getAllAnnonceParent();
    }

}
