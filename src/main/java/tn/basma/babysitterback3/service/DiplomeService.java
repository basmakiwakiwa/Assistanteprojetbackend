package tn.basma.babysitterback3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.repositories.DiplomeRepository;

import java.util.List;

@Service
public class DiplomeService {

    @Autowired
    private DiplomeRepository diplomeRepository;

    // Method to create a new diploma
    public Diplome createDiplome(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    // Method to retrieve a diploma by ID
    public Diplome getDiplomeById(Long id) {
        return diplomeRepository.findById(id).orElse(null);
    }

    // Method to update an existing diploma
    public Diplome updateDiplome(Diplome diplome) {
        // Check if the diploma exists
        if (diplome.getId() == null || !diplomeRepository.existsById(diplome.getId())) {
            // Diploma doesn't exist
            return null; // Or throw an exception
        }
        return diplomeRepository.save(diplome);
    }

    // Method to delete a diploma by ID
    public void deleteDiplome(Long id) {
        diplomeRepository.deleteById(id);
    }



    // Method to get all diplomas
    public List<Diplome> getAllDiplomes() {
        return diplomeRepository.findAll();
    }
    // Other methods as needed...

}
