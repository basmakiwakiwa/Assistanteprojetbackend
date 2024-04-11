package tn.basma.babysitterback3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.Role;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nom;
    private String prenom;
    private String sexe;
    private String email;
    private String password;
    private String confirmeMDP;
    private int mobile;
    private Role role;
}

