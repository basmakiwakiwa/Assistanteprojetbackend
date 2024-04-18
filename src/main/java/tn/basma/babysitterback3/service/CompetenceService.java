package tn.basma.babysitterback3.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.entites.Competence;
import tn.basma.babysitterback3.repositories.CompetenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Optional<Competence> getCompetenceById(Long id) {
        return competenceRepository.findById(id);
    }

    public Competence createCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public Competence updateCompetence(Long id, Competence newCompetence) {
        return competenceRepository.findById(id).map(competence -> {
            competence.setDescompetence(newCompetence.getDescompetence());
            return competenceRepository.save(competence);
        }).orElse(null);
    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }
}
