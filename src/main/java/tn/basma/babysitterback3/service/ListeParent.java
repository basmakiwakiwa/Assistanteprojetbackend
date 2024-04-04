package tn.basma.babysitterback3.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import tn.basma.babysitterback3.entites.Parent;

import tn.basma.babysitterback3.repositories.ParentRepo;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListeParent implements listeParentinter{
    @Autowired
    private ParentRepo parentrep;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void deleteUser(Long iduser) {
        // TODO Auto-generated method stub
        parentrep.deleteById(iduser);

    }





    @Override
    public List<Parent> getAllParent() {
       return parentrep.findAll();
    }

    @Override
    public Parent updateParent(Long iduser, Parent parent) {
        Parent parents= parentrep.findById(iduser).get();

        parents.setNom(parent.getNom());
        parents.setPrenom(parent.getPrenom());
        parents.setEmail(parent.getEmail());
        parents.setPassword(passwordEncoder.encode(parent.getPassword()));
        parents.setConfirmeMDP(passwordEncoder.encode(parent.getConfirmeMDP()));
        parents.setSexe(parent.getSexe());
        parents.setMobile(parent.getMobile());
        parents.setAdresse(parent.getAdresse());

        return  parentrep.save(parents);



    }

}
