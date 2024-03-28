package tn.basma.babysitterback3.service;

import org.springframework.http.ResponseEntity;
import tn.basma.babysitterback3.dto.Response;
import tn.basma.babysitterback3.entites.User;
import tn.basma.babysitterback3.entites.VerificationToken;

public interface VerificationTokenService {
    void saveUserVerificationToken(User user, String token);
    String validateToken(String token);
    ResponseEntity<Response> verifyEmail(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
}