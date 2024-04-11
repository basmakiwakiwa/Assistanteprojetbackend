package tn.basma.babysitterback3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.repositories.AnnonceParentRepository;
import tn.basma.babysitterback3.repositories.ParentRepo;

import java.util.List;
@Service
public class AnnonceParents  implements AnnonceParentInter{
    @Autowired

    private AnnonceParentRepository AnnonceParRep;
    @Autowired
    private ParentRepo parentRepo;

    // hthya methode mta3 methode ajoute annonce litab3a parent
    //bch ntastou kn parent mawjoud fil base de donne ynajm yaml annonnce w kn mch mawjoud maynjmch
    //hthya manjam namlha kn ki naml relation mabin annonnce wel parent

    @Override
    public AnnonceParent AjouteAnnonceParent(Long id ,AnnonceParent Annonce) {
        Parent parent = parentRepo.getParentById(id);
        if (parent!=null)
        {
            Annonce.setParent(parent);
            return AnnonceParRep.save(Annonce);
        }else{

            throw new IllegalArgumentException("Parent not found");

    }

    }












    //hthya methode modifier par exemple nhb naml modif 3al annonnce eli 3maltha donnc hthya hya methode
    // tw nektbha detaille fil awra9
    @Override
    public AnnonceParent updateAnnonce(Long idAnnonceParent, AnnonceParent Annonce) {
        AnnonceParent existingAnnonce = AnnonceParRep.findById(idAnnonceParent).orElse(null);
        if(existingAnnonce!=null)
        {
            existingAnnonce.setTitreannonce(Annonce.getTitreannonce());
            existingAnnonce.setDescription(Annonce.getDescription());
            existingAnnonce.setNombreEnfants(Annonce.getNombreEnfants());
            existingAnnonce.setDatedebut(Annonce.getDatedebut());
            existingAnnonce.setDatefin(Annonce.getDatefin());
            existingAnnonce.setBudget(Annonce.getBudget());
            existingAnnonce.setEmplacement(Annonce.getEmplacement());
            existingAnnonce.setLanguesparlees(Annonce.getLanguesparlees());
            existingAnnonce.setAgedesenfants(Annonce.getAgedesenfants());


            existingAnnonce.setCaracteristiquesdesenfants(Annonce.getCaracteristiquesdesenfants());




            return AnnonceParRep.save(existingAnnonce);
        }

        return null;
    }

    //hthya methode supprimer Annonce mta3 parent

    @Override
    public void deleteAnnonce(Long iduser) {
        // TODO Auto-generated method stub
        AnnonceParRep.deleteById(iduser);
    }


    //hthya bch tafichili annonce eli a3mlthom el koul

    @Override
    public List<AnnonceParent> getAllAnnonceParent() {
        return AnnonceParRep.findAll();


    }
}
