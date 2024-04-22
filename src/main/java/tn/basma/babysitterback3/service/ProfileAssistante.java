package tn.basma.babysitterback3.service;


import tn.basma.babysitterback3.entites.auxiliairesdevie;

import java.util.Optional;

public interface ProfileAssistante {

    public Optional<auxiliairesdevie> getauxiliairesdevie(String email);



    //hthya methode modifier information parent
    public void saveauxiliairesdevie(auxiliairesdevie auxiliairesdevies);
}
