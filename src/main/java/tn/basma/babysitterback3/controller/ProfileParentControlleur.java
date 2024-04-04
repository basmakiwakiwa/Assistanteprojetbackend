package tn.basma.babysitterback3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.service.ProfileParentServiceimpl;

import java.util.Optional;

@RequestMapping("/ProfileParent")

@RestController
public class ProfileParentControlleur {

    @Autowired
    ProfileParentServiceimpl profileParentServiceimpl;

//hthya methode mta3 affiche parent par id
    @GetMapping(value = "/parent/{email}")
    public Optional<Parent> getParent(@PathVariable String email) {

        return profileParentServiceimpl.getParent(email);

    }


}
