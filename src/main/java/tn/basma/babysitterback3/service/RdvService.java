package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.Rdv;

import java.util.List;

public interface RdvService {
    public Rdv saveRdvWithParent(Long id,Long idauxiliaires, Rdv rdv);

    List<Rdv> getAllRdvsByParentId(Long id);


    boolean deleteRdv(Long rdvId);

    Rdv updateRdv(Long rdvId, Rdv rdvDetails);


    List<Rdv> getRdvByAuxiliaireId(Long auxiliaireId);

//hthya mta3 accepte rdv
    Rdv accepterRdv(Long idRdv);

//hthya methode non accepte
    Rdv refuserRdv(Long idRdv);


    Rdv mettreEnAttenteRdv(Long idRdv);

}
