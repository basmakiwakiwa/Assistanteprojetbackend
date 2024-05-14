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
            emaildetails.setMessageBody("Votre message ici...");
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
            // Mettre à jour les propriétés du RDV avec les nouvelles valeurs
            existingRdv.setDescription(rdvDetails.getDescription());
            existingRdv.setEtatrdv(rdvDetails.getEtatrdv());
            existingRdv.setFixepar(rdvDetails.getFixepar());
            // Enregistrer les modifications en base de données
            return rdvRepository.save(existingRdv);
        }
        return null;
    }



    @Override
    public List<Rdv> getRdvByAuxiliaireId(Long auxiliaireId) {
        return rdvRepository.findByAuxiliairesdeviesId(auxiliaireId);
    }





}
