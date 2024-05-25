package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.dispo;
@Repository
public interface dispoRepository extends JpaRepository<dispo, Long> {
}
