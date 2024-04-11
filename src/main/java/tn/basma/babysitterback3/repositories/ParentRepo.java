package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.basma.babysitterback3.entites.Parent;

import java.util.Optional;

public interface ParentRepo extends JpaRepository<Parent,Long> {


    Optional<Parent> findByEmail(String email);

    Parent getParentById(Long id);
}
