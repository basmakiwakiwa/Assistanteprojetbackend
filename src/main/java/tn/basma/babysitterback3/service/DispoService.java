package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.entites.dispo;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.dispoRepository;

@Service
@RequiredArgsConstructor
public class DispoService {

    @Autowired
    private final dispoRepository DispoRepository;
    @Autowired
    private AssistanteRepo assistanteRepo;

    public dispo addDispoToAuxiliaire(Long auxiliaireId, dispo newDispo) {
        auxiliairesdevie auxiliaire = assistanteRepo.findById(auxiliaireId)
                .orElseThrow(() -> new RuntimeException("Auxiliaire de vie not found"));

        newDispo.setAuxiliairesdeviesss(auxiliaire);
        dispo savedDispo = DispoRepository.save(newDispo);

        auxiliaire.setDispos(savedDispo);
        assistanteRepo.save(auxiliaire);

        return savedDispo;
    }


    public dispo getDispoById(Long dispoId) {
        // Implémentez la logique pour rechercher la disponibilité par ID
        return  DispoRepository.findById(dispoId).orElse(null);
    }
}
