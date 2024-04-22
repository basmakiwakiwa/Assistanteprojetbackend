package tn.basma.babysitterback3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.service.ListeAssistanteImp;

import java.util.List;

@RequestMapping("/api/v1/listeAssistante")

@RestController
public class ListeAssistanteController {

    @Autowired
    ListeAssistanteImp listeAssistanteserv;


    @DeleteMapping(value="/deleteuser/{user_id}")
    public void deleteauxiliairesdevie(@PathVariable Long user_id)
    {
        listeAssistanteserv.deleteauxiliairesdevie(user_id);
    }



    @GetMapping("/affichelisteauxiliairesdevie")
    public List<auxiliairesdevie> getAllauxiliairesdevie()
    {
        return  listeAssistanteserv.getAllauxiliairesdevie();
    }
}
