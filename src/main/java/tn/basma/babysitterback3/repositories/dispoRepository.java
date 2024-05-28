package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.dispo;

import java.util.List;

@Repository
public interface dispoRepository extends JpaRepository<dispo, Long> {

    @Query("SELECT d FROM dispo d WHERE d.auxiliairesdeviesss.id = :auxiliaireId")
    List<dispo> findByAuxiliaireId(@Param("auxiliaireId") Long auxiliaireId);
}
