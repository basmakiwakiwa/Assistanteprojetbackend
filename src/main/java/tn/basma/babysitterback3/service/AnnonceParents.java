package tn.basma.babysitterback3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.AnnonceDeto;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.Services;
import tn.basma.babysitterback3.repositories.AnnonceParentRepository;
import tn.basma.babysitterback3.repositories.ParentRepo;
import tn.basma.babysitterback3.repositories.ServiceAssistanteRepository;

import java.util.List;

@Service
public class AnnonceParents  implements AnnonceParentInter{
    @Autowired
    private AnnonceParentRepository AnnonceParRep;

    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private ServiceAssistanteRepository serviceAssistanteRepository;

    // hthya methode mta3 methode ajoute annonce litab3a parent
    //bch ntastou kn parent mawjoud fil base de donne ynajm yaml annonnce w kn mch mawjoud maynjmch
    //hthya manjam namlha kn ki naml relation mabin annonnce wel parent

    @Override
    public AnnonceParent AjouteAnnonceParent(Long id , AnnonceDeto Annonce) {
        Parent parent = parentRepo.getParentById(id);
        AnnonceParent annonceParent = AnnonceDeto.toEntity(Annonce);

        Services services = serviceAssistanteRepository.findById(Annonce.getIdservice()).get();
        if (parent!=null)
        {    annonceParent.setActivites(services);
            annonceParent.setParent(parent);
            return AnnonceParRep.save(annonceParent);
        }else{

            throw new IllegalArgumentException("Parent not found");

    }

    }


    //methode get annonce
    @Override
    public List<AnnonceParent> getAllAnnonce() {
        return AnnonceParRep.findAll();
    }

    //hthya methode modifier mta3 annonce w fi westha modifier mta3 service zede
    @Override
    public AnnonceParent modifierAnnonceParentByParentId( Long idAnnonceParent, AnnonceDeto newAnnonce) {

        AnnonceParent existingAnnonce = AnnonceParRep.findById(idAnnonceParent)
                .orElseThrow(() -> new IllegalArgumentException("Announcement not found"));



        // Mettre à jour l'annonce existante avec les nouveaux détails
        existingAnnonce.setTitreannonce(newAnnonce.getTitreannonce());
        existingAnnonce.setDescription(newAnnonce.getDescription());
        existingAnnonce.setDatedebut(newAnnonce.getDatedebut());
        existingAnnonce.setDatefin(newAnnonce.getDatefin());
        existingAnnonce.setEmplacement(newAnnonce.getEmplacement());
        existingAnnonce.setLanguesparlees(newAnnonce.getLanguesparlees());

        //Modifier les activités de l'annonce parent
        Services services = serviceAssistanteRepository.findById(newAnnonce.getIdservice())
                .orElseThrow(() -> new IllegalArgumentException("Services not found"));
        existingAnnonce.setActivites(services);

        return AnnonceParRep.save(existingAnnonce);
    }



    public void supprimerAnnonceParentById(Long idAnnonceParent) {
        // Ajoutez votre logique de suppression ici, par exemple :
        AnnonceParRep.deleteById(idAnnonceParent);
    }




//hthya methode supprimer
   /* @Override
    @Transactional // Add @Transactional annotation here
    public void deleteAnnouncementForParentById(Long id, Long idAnnonceParent) {
        AnnonceParRep.deleteByIdAnnonceParentAndParentId(idAnnonceParent, id);
    }
*/
}
