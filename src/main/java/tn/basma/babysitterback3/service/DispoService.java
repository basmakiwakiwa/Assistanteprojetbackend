package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.entites.dispo;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.dispoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DispoService   implements DispoServiceinter {

    @Autowired
    private final dispoRepository DispoRepository;
    @Autowired
    private AssistanteRepo assistanteRepo;

    @Override
    public dispo addDispoToAuxiliaire(Long auxiliaireId, dispo newDispo) {
        auxiliairesdevie auxiliaire = assistanteRepo.findById(auxiliaireId)
                .orElseThrow(() -> new RuntimeException("Auxiliaire de vie not found"));

        newDispo.setAuxiliairesdeviesss(auxiliaire);
        dispo savedDispo = DispoRepository.save(newDispo);

        auxiliaire.setDispos(savedDispo);
        assistanteRepo.save(auxiliaire);

        return savedDispo;
    }

    @Override
    public List<dispo> getDisposByAuxiliaireId(Long auxiliaireId) {
        return DispoRepository.findByAuxiliaireId(auxiliaireId);
    }

}