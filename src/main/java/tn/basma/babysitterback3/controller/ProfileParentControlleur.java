package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.service.ProfileParentServiceimpl;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/ProfileParent")
@RequiredArgsConstructor
@RestController
public class ProfileParentControlleur {

    @Autowired
    ProfileParentServiceimpl profileParentServiceimpl;
    private final PasswordEncoder passwordEncoder;


//hthya methode mta3 affiche parent par email
    @GetMapping(value = "/parent/{email}")
    public Optional<Parent> getParent(@PathVariable String email) {

        return profileParentServiceimpl.getParent(email);

    }


//hthya methoode modifier les information de profile  parent
    @PostMapping(value = "/ModifierProfileparent")
    public boolean updateParent(@RequestBody Parent updatedParent) {
        Optional<Parent> optionalParent = profileParentServiceimpl.getParent(updatedParent.getEmail());
        if (optionalParent.isPresent()) {
            Parent parent = optionalParent.get();

            parent.setNom(updatedParent.getNom());
            parent.setPrenom(updatedParent.getPrenom());
            parent.setEmail(updatedParent.getEmail());
            parent.setMobile(updatedParent.getMobile());
            parent.setSexe(updatedParent.getSexe());
            parent.setAdresse(updatedParent.getAdresse());

            profileParentServiceimpl.saveParent(parent);
            return true;
        } else {
            return false;
        }


    }

    }







