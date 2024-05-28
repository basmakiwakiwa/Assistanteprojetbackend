package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.dispo;

import java.util.List;

public interface DispoServiceinter {

    dispo addDispoToAuxiliaire(Long auxiliaireId, dispo newDispo);


     List<dispo> getDisposByAuxiliaireId(Long auxiliaireId);

}
