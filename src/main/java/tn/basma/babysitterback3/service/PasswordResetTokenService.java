package tn.basma.babysitterback3.service;

import org.springframework.http.ResponseEntity;
import tn.basma.babysitterback3.entites.ChangePasswordResetRequest;
import tn.basma.babysitterback3.entites.Responseemailpwdoub;
import tn.basma.babysitterback3.entites.Verifpwdemail;
import tn.basma.babysitterback3.entites.Verifyotppwdoublier;

public interface PasswordResetTokenService {
    ResponseEntity<Responseemailpwdoub> verifyEmail(Verifpwdemail email);

    ResponseEntity<Responseemailpwdoub> verifyOtp(Verifyotppwdoublier verif);
    ResponseEntity<Responseemailpwdoub> changePasswordHandler(ChangePasswordResetRequest changePasswordResetRequest

    );

}