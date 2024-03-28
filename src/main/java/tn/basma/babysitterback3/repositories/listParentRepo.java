package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.basma.babysitterback3.entites.Parent;
import tn.basma.babysitterback3.entites.User;

@Repository
public interface listParentRepo extends JpaRepository<Parent,Long> {

}
