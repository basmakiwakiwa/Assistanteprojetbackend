package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.Rdvauxiliaires;

import java.util.List;

public interface RdvauxiliairesService {

    public Rdvauxiliaires saveRdvWithauxiliairesdevie(Long id, Long auxiliairesdevie_id, Rdvauxiliaires rdv);


    List<Rdvauxiliaires> getRdvByAuxiliaireId(Long id);

    void deleteRdvauxiliairesById(Long id);

    Rdvauxiliaires updateRdv(Long rdvId, Rdvauxiliaires rdvDetails);


    List<Rdvauxiliaires> getRdvByParentId(Long parentId);

    Rdvauxiliaires accepterRdv(Long idRdv);
    Rdvauxiliaires refuserRdv(Long idRdv);
    Rdvauxiliaires  mettreEnAttenteRdv(Long idRdv);
    // New method


}
