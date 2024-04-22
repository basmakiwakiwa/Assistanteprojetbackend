package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PreofileAssistanteImp  implements ProfileAssistante {

    @Autowired
    public AssistanteRepo assistanteRepo;

    @Override
    public Optional<auxiliairesdevie> getauxiliairesdevie(String email) {
        return assistanteRepo.findByEmail(email);
    }


    @Override
    public void saveauxiliairesdevie(auxiliairesdevie auxiliairesdevies) {
        assistanteRepo.save(auxiliairesdevies);
    }

}
