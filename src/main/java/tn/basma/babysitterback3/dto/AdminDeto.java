package tn.basma.babysitterback3.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.Admin;
import tn.basma.babysitterback3.entites.Parent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@SuperBuilder
public class AdminDeto  extends RegisterRequest{
    private boolean isAdmin;
    public static Admin toEntity(AdminDeto request) {
        return Admin.builder()

                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .sexe(request.getSexe())
                .confirmeMDP(request.getConfirmeMDP())
                .isAdmin(request.isAdmin())

                .role(request.getRole())
                .build();
    }

}
