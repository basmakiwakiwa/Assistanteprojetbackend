package tn.basma.babysitterback3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.EmailDetails;
import tn.basma.babysitterback3.entites.*;
import tn.basma.babysitterback3.repositories.ForgotPasswordTokenRepository;
import tn.basma.babysitterback3.repositories.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService  {
    private final UserRepository userRepository;
    private final ForgotPasswordTokenRepository forgotPasswordRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    //send mail for email verification pwd oublier
    public ResponseEntity<Responseemailpwdoub> verifyEmail(Verifpwdemail email){
        User user = userRepository.findByEmail(email.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Please provide an valid email"));

        forgotPasswordRepository.deleteotpduplique(user.getId());
        //time to formulate the mail body

        int token = otpGenerator();
        EmailDetails mailBody = EmailDetails
                .builder()
                .to(email.getEmail())
                .subject("OTP for Forgot Password request")
                .messageBody("This is the OTP for your Forgot Password request : " + token)
                .build();
        ForgotPasswordToken fp = ForgotPasswordToken
                .builder()
                .token(token)
                //.expirationTime(new Date(System.currentTimeMillis() + 24 * 60 * 1000))
                .expirationTime(Date.from(Instant.now().plus(24, ChronoUnit.HOURS)))

                .user(user)
                .build();
        Responseemailpwdoub message = Responseemailpwdoub.builder().messageResponse("avec succees")
                .build();
        //Send Mail
        emailService.sendMail(mailBody);
        forgotPasswordRepository.save(fp);

        return ResponseEntity.ok(message);

    }

    public ResponseEntity<Responseemailpwdoub> verifyOtp(Verifyotppwdoublier verif){
        User user = userRepository.findByEmail(verif.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Please provide an valid email"));

        ForgotPasswordToken fp =forgotPasswordRepository.findByTokenAndUser(verif.getOtp(),user)

                .orElseThrow(()-> new RuntimeException("Invalid OTP for email"+verif.getEmail() ));
        System.out.println(fp);



        Responseemailpwdoub message = Responseemailpwdoub.builder().messageResponse("avec succees")
                .build();

        return ResponseEntity.ok(message);

    }


    //Now User Can change the password pwdoublier///////////// communt

    public ResponseEntity<Responseemailpwdoub> changePasswordHandler(ChangePasswordResetRequest changePassword){
        boolean areEqual = (changePassword.getNewPassword()).equals(changePassword.getConfirmationPassword());

        Responseemailpwdoub message = Responseemailpwdoub.builder().messageResponse("avec succees")
                .build();

        //We need to encode password
        String encodedPassword = passwordEncoder.encode(changePassword.getNewPassword());
        userRepository.updatePassword(changePassword.getEmail(),encodedPassword);

        return ResponseEntity.ok(message);

    }


    private Integer otpGenerator(){
        Random random = new Random();
        return random.nextInt(100_000,999_999);//Minimum && Maximum
    }
}