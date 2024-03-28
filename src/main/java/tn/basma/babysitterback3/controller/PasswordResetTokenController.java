package tn.basma.babysitterback3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.dto.ChangePasswordResetRequest;
import tn.basma.babysitterback3.entites.User;
import tn.basma.babysitterback3.service.PasswordResetTokenService;
import tn.basma.babysitterback3.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class PasswordResetTokenController {
    private final UserService service;
    private final PasswordResetTokenService passwordResetTokenService;
    @GetMapping("/{email}")
    public User fetchUser(@PathVariable String email) {
        return service.fetchUser(email);
    }


    //send mail for email verification
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){

        return passwordResetTokenService.verifyEmail(email);

    }


    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp,@PathVariable String email){
        return passwordResetTokenService.verifyOtp(otp, email);
    }

    //hthya methode change mot de passe

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(
            @RequestBody ChangePasswordResetRequest changePassword,
            @PathVariable String email
    ){
        return passwordResetTokenService.changePasswordHandler(changePassword,email);
    }

}
