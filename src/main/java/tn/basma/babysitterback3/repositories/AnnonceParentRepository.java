package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.entites.Parent;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnonceParentRepository extends JpaRepository<AnnonceParent,Long> {
    Optional<AnnonceParent> findByParent(Parent parent);
    Optional<AnnonceParent> findByIdAnnonceParent(Long id);
    void deleteByIdAnnonceParentAndParentId(Long idAnnonceParent, Long id);

    List<AnnonceParent> findAllByParent(Parent parent);
}
