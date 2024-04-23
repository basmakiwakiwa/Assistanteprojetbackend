package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.service.DiplomeService;
import tn.basma.babysitterback3.service.ProfileAssistanteImp;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/api/v1/ProfileAssistante")
@RequiredArgsConstructor
@RestController
public class ProfileAssistanteController {

    @Autowired
    ProfileAssistanteImp profileAssistanteImp ;

    private DiplomeService diplomeService;
    private final PasswordEncoder passwordEncoder;

    //hthya methode mta3 affiche profile mta3 assistante par email
    @GetMapping(value = "/Assistante/{email}")
    public Optional<auxiliairesdevie> getauxiliairesdevie(@PathVariable String email) {

        return profileAssistanteImp.getauxiliairesdevie(email);

    }




//hthya methoode modifier les information de profile  parent
    @PostMapping(value = "/ProfileAssistante")
    public boolean updateAssistante(@RequestBody auxiliairesdevie updatedAssistante) {
        Optional<auxiliairesdevie> optionalAssistante = profileAssistanteImp.getauxiliairesdevie(updatedAssistante.getEmail());
        if (optionalAssistante.isPresent()) {
            auxiliairesdevie auxiliairesdevies = optionalAssistante.get();

            auxiliairesdevies.setNom(updatedAssistante.getNom());
            auxiliairesdevies.setPrenom(updatedAssistante.getPrenom());
            auxiliairesdevies.setEmail(updatedAssistante.getEmail());
            auxiliairesdevies.setMobile(updatedAssistante.getMobile());
            auxiliairesdevies.setSexe(updatedAssistante.getSexe());
            auxiliairesdevies.setAdresse(updatedAssistante.getAdresse());
            auxiliairesdevies.setDescription(updatedAssistante.getDescription());
            auxiliairesdevies.setDateN(updatedAssistante.getDateN());
            auxiliairesdevies.setBudget(updatedAssistante.getBudget());
            auxiliairesdevies.setLangues(updatedAssistante.getLangues());
            auxiliairesdevies.setNiveaudeetude(updatedAssistante.getNiveaudeetude());
            auxiliairesdevies.setEtatcivil(updatedAssistante.getEtatcivil());
            auxiliairesdevies.setDiplomeBabysitter(updatedAssistante.getDiplomeBabysitter());
            auxiliairesdevies.setCompetanceAuxiliairesdevie(updatedAssistante.getCompetanceAuxiliairesdevie());
            auxiliairesdevies.setActivitesAuxiliairesdevie(updatedAssistante.getActivitesAuxiliairesdevie());
            profileAssistanteImp.saveauxiliairesdevie(auxiliairesdevies);
            return true;
        } else {
            return false;
        }


    }

}







