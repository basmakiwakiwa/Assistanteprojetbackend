package tn.basma.babysitterback3.service;

import tn.basma.babysitterback3.dto.AnnonceDeto;
import tn.basma.babysitterback3.entites.AnnonceParent;

import java.util.List;

public interface AnnonceParentInter {
    // hthya signature mta3 methode ajoute annonce litab3a parent par exemple bch nchoffa kn parent mawjoud ynajm yhabt annonce w kn mch mawjoud msajl mynajmch yhbt


    public AnnonceParent AjouteAnnonceParent(Long id , AnnonceDeto Annonce);
    List<AnnonceParent> getAllAnnonce();
    public AnnonceParent modifierAnnonceParentByParentId(Long idAnnonceParent, AnnonceDeto newAnnonce);

    //public void deleteAnnouncementForParentById(Long id, Long idAnnonceParent);
}
