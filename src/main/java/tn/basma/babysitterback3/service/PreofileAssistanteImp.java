package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;
import tn.basma.babysitterback3.repositories.DiplomeRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PreofileAssistanteImp  implements ProfileAssistante {

    @Autowired
    public AssistanteRepo assistanteRepo;
    private DiplomeRepository diplomeRepository;
    @Override
    public Optional<auxiliairesdevie> getauxiliairesdevie(String email) {
        return assistanteRepo.findByEmail(email);
    }


    @Override
    public void saveauxiliairesdevie(auxiliairesdevie auxiliairesdevies) {
        assistanteRepo.save(auxiliairesdevies);
    }


    public List<Diplome> getAllDiplome() {
        return diplomeRepository.findAll();
    }




}
