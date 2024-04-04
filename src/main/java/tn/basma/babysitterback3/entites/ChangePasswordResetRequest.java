package tn.basma.babysitterback3.entites;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
// pour pwd oublier : auth n'est pas obligatoire
public class ChangePasswordResetRequest {
    private String newPassword;
    private String confirmationPassword;
    private String email;
}