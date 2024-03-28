package tn.basma.babysitterback3.service;

import org.springframework.http.ResponseEntity;
import tn.basma.babysitterback3.dto.ChangePasswordResetRequest;

public interface PasswordResetTokenService {
    ResponseEntity<String> verifyEmail(String email);

    ResponseEntity<String> verifyOtp(Integer otp, String email);

    ResponseEntity<String> changePasswordHandler(
            ChangePasswordResetRequest changePasswordResetRequest,
            String email
    );

}