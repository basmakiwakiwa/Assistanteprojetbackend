package tn.basma.babysitterback3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.repositories.listParentRepo;

import java.util.List;

@Service
public class ListeParent implements listeParentinter{
    @Autowired
    private listParentRepo ListeParRepo;



    //hthya methode supprimer liste mta3 parent










    //hthya bch tafichili liste parent eli a3mlthom el koul

    @Override
    public List<Parent> getAllParent() {
        return ListeParRepo.findAll();


    }





}
