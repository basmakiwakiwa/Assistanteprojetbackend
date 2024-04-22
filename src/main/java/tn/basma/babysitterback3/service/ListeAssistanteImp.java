package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.AssistanteRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListeAssistanteImp implements  ListeAssistante{


    @Autowired
    private AssistanteRepo assistanteRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void deleteauxiliairesdevie(Long iduser) {
        // TODO Auto-generated method stub
        assistanteRepo.deleteById(iduser);
    }

    @Override
    public List<auxiliairesdevie> getAllauxiliairesdevie () {
        return assistanteRepo.findAll();
    }




}
