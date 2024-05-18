package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.EmailDetails;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.Rdv;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.ParentRepo;
import tn.basma.babysitterback3.repositories.RdvParentRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RdvServiceImpl implements RdvService {

    @Autowired
    private RdvParentRepo rdvRepository;
    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private AssistanteRepo assistanteRepo ;
    @Autowired
    private  EmailService emailService;



    @Override
    public Rdv saveRdvWithParent(Long id, Long idauxiliaires, Rdv rdv) {
        // Vérification des IDs
        Optional<Parent> parentOptional = parentRepo.findById(id);
        Optional<auxiliairesdevie> auxiliairesOptional = assistanteRepo.findById(idauxiliaires);

        if (parentOptional.isPresent() && auxiliairesOptional.isPresent()) {
            Parent parent = parentOptional.get();
            auxiliairesdevie auxiliaire = auxiliairesOptional.get();

            // Assignation de l'auxiliaire
            rdv.setParent(parent);
            rdv.setAuxiliairesdevies(auxiliaire);

            // Envoi de l'email
            EmailDetails emaildetails = new EmailDetails();
            emaildetails.setTo(auxiliaire.getEmail());
            emaildetails.setSubject("Demande de rendez-vous");
            emaildetails.setMessageBody("Bonjour \n" +
                    "\n" +
                    "J'espère que vous allez bien.\n" +
                    "\n" +
                    "Je suis le parent , et je souhaite convenir d'un rendez-vous pour discuter de\n" +
                    "\n" +
                    "Voici mes disponibilités pour la semaine à venir :\n" +
                    "\n" +
                    "Lundi : de 10h à 12h\n" +
                    "Mardi : de 14h à 16h\n" +
                    "Mercredi : de 9h à 11h\n" +
                    "Jeudi : de 15h à 17h\n" +
                    "Pouvez-vous me confirmer un créneau qui vous convient parmi ces horaires, ou me proposer une alternative si nécessaire ?\n" +
                    "\n" +
                    "Je vous remercie d'avance pour votre disponibilité et votre attention à notre situation.");
            emailService.sendSimpleMail(emaildetails);

            // Sauvegarde du rendez-vous
            return rdvRepository.save(rdv);
        }
        return null; // Ou gestion de l'erreur selon votre logique
    }

    @Override
    public List<Rdv> getAllRdvsByParentId(Long id) {
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
    public Rdv updateRdv(Long rdvId, Rdv rdvDetails) {
        // Logique pour mettre à jour un RDV spécifié par son ID avec les détails fournis
        Optional<Rdv> rdvOptional = rdvRepository.findById(rdvId);
        if (rdvOptional.isPresent()) {
            Rdv existingRdv = rdvOptional.get();
            existingRdv.setDescription(rdvDetails.getDescription());
            existingRdv.setEtatrdv(rdvDetails.getEtatrdv());
            return rdvRepository.save(existingRdv);
        }
        return null;
    }



    @Override
    public List<Rdv> getRdvByAuxiliaireId(Long auxiliaireId) {
        return rdvRepository.findByAuxiliairesdeviesId(auxiliaireId);
    }


//hthya methode mta3 accepte rdv

    @Override
    public Rdv accepterRdv(Long idRdv) {
        Rdv rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Accepte");

        return rdvRepository.save(rdv);
    }


//hthya methode Non accepte
    @Override
    public Rdv refuserRdv(Long idRdv) {
        Rdv rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Non Accepte");

        return rdvRepository.save(rdv);
    }


    @Override
    public Rdv mettreEnAttenteRdv(Long idRdv) {
        Rdv rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("En attente");

        return rdvRepository.save(rdv);
    }





}
