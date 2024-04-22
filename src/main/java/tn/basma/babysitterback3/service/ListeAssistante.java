package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.auxiliairesdevie;

import java.util.List;

public interface ListeAssistante {

    public void deleteauxiliairesdevie(Long iduser);

    public List<auxiliairesdevie> getAllauxiliairesdevie();
}
