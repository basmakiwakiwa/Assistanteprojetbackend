package tn.basma.babysitterback3.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.EmailDetails;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.Rdvauxiliaires;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.ParentRepo;
import tn.basma.babysitterback3.repositories.RdvauxelierRepo;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class RdvauxiliairesServiceImpl implements RdvauxiliairesService {

    @Autowired
    private RdvauxelierRepo rdvRepository;
    @Autowired
    private ParentRepo parentRepo;
    @Autowired
    private AssistanteRepo assistanteRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public Rdvauxiliaires saveRdvWithauxiliairesdevie(Long id, Long auxiliairesdevie_id, Rdvauxiliaires rdv) {
        // Vérification des IDs
        Optional<Parent> parentOptional = parentRepo.findById(id);
        Optional<auxiliairesdevie> auxiliairesOptional = assistanteRepo.findById(auxiliairesdevie_id);

        if (parentOptional.isPresent() && auxiliairesOptional.isPresent()) {
            Parent parent = parentOptional.get();
            auxiliairesdevie auxiliaire = auxiliairesOptional.get();

            // Assignation du parent et de l'auxiliaire
            rdv.setParent(parent);
            rdv.setAuxiliairesdevies(auxiliaire);

            // Envoi de l'email
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setTo(parent.getEmail());
            emailDetails.setSubject("Proposition de rendez-vous");
            emailDetails.setMessageBody(rdv.getDescription());
            emailService.sendSimpleMail(emailDetails);

            // Sauvegarde du rendez-vous
            return rdvRepository.save(rdv);
        }
        return null; // Ou gestion de l'erreur selon votre logique
    }

    @Override
    public List<Rdvauxiliaires> getRdvByAuxiliaireId(Long id) {
        return rdvRepository.findByAuxiliairesdeviesId(id);
    }

    @Override
    public void deleteRdvauxiliairesById(Long id) {
        rdvRepository.deleteById(id);
    }

    @Override
    public Rdvauxiliaires updateRdv(Long rdvId, Rdvauxiliaires rdvDetails) {
        // Logique pour mettre à jour un RDV spécifié par son ID avec les détails fournis
        Optional<Rdvauxiliaires> rdvOptional = rdvRepository.findById(rdvId);
        if (rdvOptional.isPresent()) {
            Rdvauxiliaires existingRdv = rdvOptional.get();
            existingRdv.setDescription(rdvDetails.getDescription());
            existingRdv.setEtatrdv(rdvDetails.getEtatrdv());
            return rdvRepository.save(existingRdv);
        }
        return null;
    }


    @Override
    public List<Rdvauxiliaires> getRdvByParentId(Long parentId) {
        return rdvRepository.findByParentId(parentId);
    }



    @Override
    public Rdvauxiliaires accepterRdv(Long idRdv) {
        Rdvauxiliaires rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Accepte");

        return rdvRepository.save(rdv);
    }



    @Override
    public Rdvauxiliaires refuserRdv(Long idRdv) {
        Rdvauxiliaires rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("Non Accepte");

        return rdvRepository.save(rdv);
    }



    @Override
    public Rdvauxiliaires mettreEnAttenteRdv(Long idRdv) {
        Rdvauxiliaires rdv = rdvRepository.findById(idRdv)
                .orElseThrow(() -> new IllegalArgumentException("Rdv not found with id: " + idRdv));

        rdv.setEtatrdv("En attente");

        return rdvRepository.save(rdv);
    }


}


