package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.auxiliairesdevie;
import tn.basma.babysitterback3.service.PreofileAssistanteImp;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/ProfileAssistante")
@RequiredArgsConstructor
@RestController
public class ProfileAssistanteController {

    @Autowired
    PreofileAssistanteImp preofileAssistanteImp ;
    private final PasswordEncoder passwordEncoder;

    //hthya methode mta3 affiche parent par email
    @GetMapping(value = "/Assistante/{email}")
    public Optional<auxiliairesdevie> getauxiliairesdevie(@PathVariable String email) {

        return preofileAssistanteImp.getauxiliairesdevie(email);

    }

    //hthya methoode modifier les information de profile  parent
    @PostMapping(value = "/ProfileAssistante")
    public boolean updateAssistante(@RequestBody auxiliairesdevie updatedAssistante) {
        Optional<auxiliairesdevie> optionalAssistante = preofileAssistanteImp.getauxiliairesdevie( updatedAssistante.getEmail());
        if (optionalAssistante.isPresent()) {
            auxiliairesdevie auxiliairesdevies = optionalAssistante.get();
            auxiliairesdevies.setNom(updatedAssistante.getNom());
            auxiliairesdevies.setPrenom(updatedAssistante.getPrenom());
            auxiliairesdevies.setEmail(updatedAssistante.getEmail());
            auxiliairesdevies.setMobile(updatedAssistante.getMobile());
            auxiliairesdevies.setSexe(updatedAssistante.getSexe());
            auxiliairesdevies.setAdresse(updatedAssistante.getAdresse());

            preofileAssistanteImp.saveauxiliairesdevie(auxiliairesdevies);
            return true;
        } else {
            return false;
        }


    }

}







