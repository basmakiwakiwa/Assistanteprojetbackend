package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.entites.RdvParent;

import java.util.List;

public interface RdvparentService {
    public RdvParent saveRdvWithParent(Long id, Long idauxiliaires, RdvParent rdv);















    List<RdvParent> getAllRdvsByParentId(Long id);


    boolean deleteRdv(Long rdvId);

    RdvParent updateRdv(Long rdvId, RdvParent rdvDetails);


    List<RdvParent> getRdvByAuxiliaireId(Long auxiliaireId);

//hthya mta3 accepte rdv
    RdvParent accepterRdv(Long idRdv);

//hthya methode non accepte
    RdvParent refuserRdv(Long idRdv);


    RdvParent mettreEnAttenteRdv(Long idRdv);



}
