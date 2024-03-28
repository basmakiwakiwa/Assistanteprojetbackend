package tn.basma.babysitterback3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {
//hthya class tab3 change mot de passe
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}