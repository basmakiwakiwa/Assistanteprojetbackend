package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.basma.babysitterback3.entites.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}