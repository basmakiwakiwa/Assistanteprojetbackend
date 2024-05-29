package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.Image;

import java.util.Optional;
@Repository

public interface UserImageRepository extends JpaRepository<Image,Long> {

    Optional<Image> findById(Long idUser);


}