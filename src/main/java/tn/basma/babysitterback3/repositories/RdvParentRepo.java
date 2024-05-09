package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.Rdv;

import java.util.List;

@Repository
public interface RdvParentRepo extends JpaRepository<Rdv,Long> {
    List<Rdv> findByParentId(Long id);

}
