package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.EmailDetails;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.RdvParent;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.ParentRepo;
import tn.basma.babysitterback3.repositories.RdvParentRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RdvparentServiceImpl implements RdvparentService {

    @Autowired
    private RdvParentRepo rdvRepository;
    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private AssistanteRepo assistanteRepo ;
    @Autowired
    private  EmailService emailService;



    @Override
    public RdvParent saveRdvWithParent(Long id, Long idauxiliaires, RdvParent rdv) {
        // Vérification des IDs
        Optional<Parent> parentOptional = parentRepo.findById(id);
        Optional< auxiliairesdevie > auxiliairesOptional = assistanteRepo.findById(idauxiliaires);

        if (parentOptional.isPresent() && auxiliairesOptional.isPresent()) {
            Parent parent = parentOptional.get();
            auxiliairesdevie  auxiliaire = auxiliairesOptional.get();

            // Assignation du parent et de l'auxiliaire
            rdv.setParent(parent);
            rdv.setAuxiliairesdevies(auxiliaire);
            //rdv.setFixepar("Parent");

            // Définir le rôle du parent
            rdv.setRoleRDV("Parent");

            // Envoi de l'email
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setTo(auxiliaire.getEmail());
            emailDetails.setSubject("Demande de rendez-vous");
            emailDetails.setMessageBody("Bonjour " + auxiliaire.getNom() + ",\n" +
                    "\n" +
                    "J'espère que vous allez bien.\n" +
                    "\n" +
                    "Je suis " + parent.getNom() + ", votre parent, et je souhaite convenir d'un rendez-vous pour discuter de\n" +
                    "votre situation et des services dont vous avez besoin.\n" +
                    "\n" +
                    "Voici mes disponibilités pour la semaine à venir :\n" +
                    "\n" +
                    "Lundi : de 10h à 12h\n" +
                    "Mardi : de 14h à 16h\n" +
                    "Mercredi : de 9h à 11h\n" +
                    "Jeudi : de 15h à 17h\n" +
                    "Pouvez-vous me confirmer un créneau qui vous convient parmi ces horaires, ou me proposer une alternative si nécessaire ?\n" +
                    "\n" +
                    "Je vous remercie d'avance pour votre disponibilité et votre attention.\n" +
                    "\n" +
                    "Cordialement,\n" +
                    parent.getNom());
            emailService.sendSimpleMail(emailDetails);

            // Sauvegarde du rendez-vous
            return rdvRepository.save(rdv);
        }
        return null; // Ou gestion de l'erreur selon votre logique
    }



    @Override
    public List<RdvParent> getAllRdvsByParentId(Long id) {
        // Récupérer tous les rendez-vous associés à un parent spécifique
        return rdvRepository.findByParentId(id);
    }


    @Override
    public boolean deleteRdv(Long rdvId) {
        // Implémentez la logique pour supprimer un RDV par son ID ici
        if (rdvRepository.existsById(rdvId)) {
            rdvRepository.deleteById(rdvId);
            return true;
        }
        return false;
    }

    @Override
    public RdvParent updateRdv(Long rdvId, RdvParent rdvDetails) {
        // Logique pour mettre à jour un RDV spécifié par son ID avec les détails fournis
        Optional<RdvParent> rdvOptional = rdvRepository.findById(rdvId);
        if (rdvOptional.isPresent()) {
            RdvParent existingRdv = rdvOptional.get();
            existingRdv.setDescription(rdvDetails.getDescription());
            existingRdv.setEtatrdv(rdvDetails.getEtatrdv());
            return rdvRepository.save(existingRdv);
        }
        return null;
    }



    @Override
    public List<RdvParent> getRdvByAuxiliaireId(Long auxiliaireId) {
        return rdvRepository.findByAuxiliairesdeviesId(auxiliaireId);
    }


//hthya methode mta3 accepte rdv

    @Override
    public RdvParent accepterRdv(Long idRdv) {
        RdvParent rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Accepte");

        return rdvRepository.save(rdv);
    }


//hthya methode Non accepte
    @Override
    public RdvParent refuserRdv(Long idRdv) {
        RdvParent rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Non Accepte");

        return rdvRepository.save(rdv);
    }


    @Override
    public RdvParent mettreEnAttenteRdv(Long idRdv) {
        RdvParent rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("En attente");

        return rdvRepository.save(rdv);
    }



//hthya methode envoyer auxelier rdv a parent



























}























