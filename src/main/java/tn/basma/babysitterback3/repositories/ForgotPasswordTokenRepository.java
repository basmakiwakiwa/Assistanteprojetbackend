package tn.basma.babysitterback3.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



import jakarta.transaction.Transactional;
import tn.basma.babysitterback3.entites.ForgotPasswordToken;
import tn.basma.babysitterback3.entites.User;

public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {

    @Query("select fpt from ForgotPasswordToken fpt where fpt.token = ?1 and fpt.user = ?2 ")
    Optional<ForgotPasswordToken> findByTokenAndUser(Integer token, User user);




    // delete otp si il est dupliquee
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM forgot_password_token WHERE user_id = ?1", nativeQuery = true)
    void deleteotpduplique(Long userId);




}