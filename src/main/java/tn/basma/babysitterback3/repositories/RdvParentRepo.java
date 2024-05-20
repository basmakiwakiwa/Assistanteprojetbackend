package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.RdvParent;

import java.util.List;

@Repository
public interface RdvParentRepo extends JpaRepository<RdvParent,Long> {
    List<RdvParent> findByParentId(Long id);


    List<RdvParent> findByAuxiliairesdeviesId(Long auxiliaireId);



}
