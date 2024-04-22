package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.auxiliairesdevie;

import java.util.Optional;

public interface AssistanteRepo extends JpaRepository<auxiliairesdevie,Long> {
    Parent getParentById(Long id);
    Optional<auxiliairesdevie> findByEmail(String email);
}
