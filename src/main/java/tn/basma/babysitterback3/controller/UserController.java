package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.entites.ChangePasswordResetRequest;
import tn.basma.babysitterback3.entites.Responseemailpwdoub;
import tn.basma.babysitterback3.entites.Verifpwdemail;
import tn.basma.babysitterback3.entites.Verifyotppwdoublier;
import tn.basma.babysitterback3.service.PasswordResetTokenServiceImpl;
import tn.basma.babysitterback3.service.ChangePasswordService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final ChangePasswordService service;
    private  final PasswordResetTokenServiceImpl passwordResetTokenService;
    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordResetRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }


    // mot de passe oblier

    @PostMapping("/verifyMail")
    public ResponseEntity<Responseemailpwdoub> verifyEmail(@RequestBody Verifpwdemail email){
        return passwordResetTokenService.verifyEmail(email);
    }

    // 2) OTP avec email
    @PostMapping("/verifyOtp")
    public ResponseEntity<Responseemailpwdoub> verifyOtp(@RequestBody Verifyotppwdoublier verif){
        return passwordResetTokenService.verifyOtp(verif);
    }

    //3)
    //Now User Can change the password
    @PostMapping("/changerDemotPasseOublier")
    public ResponseEntity<Responseemailpwdoub> changePasswordHandler(@RequestBody ChangePasswordResetRequest changePassword){
        return passwordResetTokenService.changePasswordHandler(changePassword);
    }



}