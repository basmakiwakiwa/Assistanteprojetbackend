package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.Parent;

import java.util.Optional;

public interface ProfileParentServices {


    public Optional<Parent> getParent(String email);



    //hthya methode modifier information parent
    public void saveParent(Parent parent);
}
