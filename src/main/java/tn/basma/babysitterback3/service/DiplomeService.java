package tn.basma.babysitterback3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.repositories.DiplomeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomeService {

    @Autowired
    private DiplomeRepository diplomeRepository;



    public List<Diplome> getAllDiplome() {
        return diplomeRepository.findAll();
    }


    public Optional<Diplome> getDiplomeById(Long id) {
        return diplomeRepository.findById(id);
    }

    public Diplome createDiplome(Diplome diplome) {
        return diplomeRepository.save( diplome);
    }

    public Diplome updateDiplome(Long id, Diplome newDiplome) {
        return diplomeRepository.findById(id).map( diplome -> {
            diplome.setNomdiplom(newDiplome.getNomdiplom());
            return diplomeRepository.save( diplome);
        }).orElse(null);
    }

    public void deleteDiplome(Long id) {
        diplomeRepository.deleteById(id);
    }




}
