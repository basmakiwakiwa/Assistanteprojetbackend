package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.DiplomeRepository;
import tn.basma.babysitterback3.repositories.ParentRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileAssistanteImp implements ProfileAssistante {

    @Autowired
    public AssistanteRepo assistanteRepo;
    @Autowired
    private DiplomeRepository diplomeRepository;
    @Autowired
    private ParentRepo parentRepo;
    @Override
    public Optional<auxiliairesdevie> getauxiliairesdevie(String email) {
        return assistanteRepo.findByEmail(email);
    }


    @Override
    public void saveauxiliairesdevie(auxiliairesdevie auxiliairesdevies) {
        assistanteRepo.save(auxiliairesdevies);
    }


/*
    public Set<Parent> getParentsForAuxiliaire(Long auxiliaireId) {
        Optional<auxiliairesdevie> auxiliaireOptional = assistanteRepo.findById(auxiliaireId);
        if (auxiliaireOptional.isPresent()) {
            auxiliairesdevie auxiliaire = auxiliaireOptional.get();
            Set<Rdv> rdvs = auxiliaire.getRdvs();
            Set<Parent> parents = new HashSet<>();
            for (Rdv rdv : rdvs) {
                parents.add(rdv.getParent());
            }
            return parents;
        } else {
            throw new EntityNotFoundException("Auxiliaire de vie non trouvé avec ID: " + auxiliaireId);
        }
    }
*/
}
