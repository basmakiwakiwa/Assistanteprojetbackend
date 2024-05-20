package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.Rdvauxiliaires;

import java.util.List;

@Repository
public interface RdvauxelierRepo extends JpaRepository<Rdvauxiliaires,Long> {

    List<Rdvauxiliaires> findByParentId(Long id);


    List<Rdvauxiliaires> findByAuxiliairesdeviesId(Long auxiliaireId);
}
