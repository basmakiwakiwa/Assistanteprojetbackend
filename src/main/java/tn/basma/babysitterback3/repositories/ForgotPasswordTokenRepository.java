package tn.basma.babysitterback3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.basma.babysitterback3.entites.ForgotPasswordToken;
import tn.basma.babysitterback3.entites.User;

import java.util.Optional;

public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {
    @Query("select fpt from ForgotPasswordToken fpt where fpt.token = ?1 and fpt.user = ?2 ")
    Optional<ForgotPasswordToken> findByTokenAndUser(Integer token, User user);
}