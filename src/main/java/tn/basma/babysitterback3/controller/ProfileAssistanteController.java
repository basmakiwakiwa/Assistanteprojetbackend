package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Activites;
import tn.basma.babysitterback3.entites.Competence;
import tn.basma.babysitterback3.entites.Diplome;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.repositories.ActivitesRepository;
import tn.basma.babysitterback3.repositories.CompetenceRepository;
import tn.basma.babysitterback3.repositories.DiplomeRepository;
import tn.basma.babysitterback3.service.ProfileAssistanteImp;

import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/api/v1/ProfileAssistante")
@RequiredArgsConstructor
@RestController
public class ProfileAssistanteController {

    @Autowired
    ProfileAssistanteImp profileAssistanteImp ;



    private  final DiplomeRepository diplomeRepository;
private  final ActivitesRepository activitesRepository ;
private  final CompetenceRepository  competenceRepository;


    //hthya methode mta3 affiche profile mta3 assistante par email
    @GetMapping(value = "/Assistante/{email}")
    public Optional<auxiliairesdevie> getauxiliairesdevie(@PathVariable String email) {

        return profileAssistanteImp.getauxiliairesdevie(email);

    }


    @PutMapping("/Assistante/{email}")
    public ResponseEntity<String> modifierAuxiliaireDeVie(@PathVariable String email, @RequestBody auxiliairesdevie auxiliaireDeVieModifie) {
        // Récupérez l'auxiliaire de vie à modifier
        Optional<auxiliairesdevie> auxiliaireDeVieOptional = profileAssistanteImp.getauxiliairesdevie(email);

        if (auxiliaireDeVieOptional.isPresent()) {
            auxiliairesdevie auxiliaireDeVie = auxiliaireDeVieOptional.get();

            // Mettez à jour les informations de l'auxiliaire de vie avec les nouvelles données
            auxiliaireDeVie.setNom(auxiliaireDeVieModifie.getNom());
            auxiliaireDeVie.setPrenom(auxiliaireDeVieModifie.getPrenom());
            auxiliaireDeVie.setEmail(auxiliaireDeVieModifie.getEmail());
            auxiliaireDeVie.setMobile(auxiliaireDeVieModifie.getMobile());
            auxiliaireDeVie.setSexe(auxiliaireDeVieModifie.getSexe());
            auxiliaireDeVie.setDescription(auxiliaireDeVieModifie.getDescription());
            auxiliaireDeVie.setDateN(auxiliaireDeVieModifie.getDateN());
            auxiliaireDeVie.setBudget(auxiliaireDeVieModifie.getBudget());
            auxiliaireDeVie.setLangues(auxiliaireDeVieModifie.getLangues());
            auxiliaireDeVie.setAdresse(auxiliaireDeVieModifie.getAdresse());
            auxiliaireDeVie.setCin(auxiliaireDeVieModifie.getCin());
            auxiliaireDeVie.setEtatcivil(auxiliaireDeVieModifie.getEtatcivil());
            auxiliaireDeVie.setNiveaudeetude(auxiliaireDeVieModifie.getNiveaudeetude());
//hthya code mta3 diplome ki nhb namlou modifier 5atrou liste 5atr amltou kima lokhrinn mahabch

            if (auxiliaireDeVieModifie.getIddiplome() != null) {
                Set<Diplome> diplomes = auxiliaireDeVie.getDiplomeBabysitter();
                diplomes.clear();
                for (Long idDiplome : auxiliaireDeVieModifie.getIddiplome()) {
                    Diplome diplome = diplomeRepository.findById(idDiplome)
                            .orElseThrow(() -> new IllegalArgumentException("Diplome non trouvé pour l'ID: " + idDiplome));
                    diplomes.add(diplome);
                }
            }

            if (auxiliaireDeVieModifie.getIdcompetance() != null) {
                Set<Competence> competences = auxiliaireDeVie.getCompetanceAuxiliairesdevie();
                competences.clear();
                for (Long idCompetence : auxiliaireDeVieModifie.getIdcompetance()) {
                    Competence competence = competenceRepository.findById(idCompetence)
                            .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée pour l'ID: " + idCompetence));
                    competences.add(competence);
                }
            }

            if (auxiliaireDeVieModifie.getIdActivite() != null) {
                Set<Activites> activites = auxiliaireDeVie.getActivitesAuxiliairesdevie();
                activites.clear();
                for (Long idActivite : auxiliaireDeVieModifie.getIdActivite()) {
                    Activites activite = activitesRepository.findById(idActivite)
                            .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée pour l'ID: " + idActivite));
                    activites.add(activite);
                }
            }


            // Sauvegardez les modifications
            profileAssistanteImp.saveauxiliairesdevie(auxiliaireDeVie);

            return ResponseEntity.ok("Auxiliaire de vie modifié avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

















    }




































