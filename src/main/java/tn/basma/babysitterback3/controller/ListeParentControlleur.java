package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.service.ListeParent;

import java.util.List;

@RequestMapping("/listeparent")

@RestController
public class ListeParentControlleur {

    @Autowired
    ListeParent listParentServ;






    //methode affiche liste parents

    @GetMapping("/affichelisteParent")
    public List<Parent> getAllParent ()
    {
        return  listParentServ.getAllParent();
    }
}
