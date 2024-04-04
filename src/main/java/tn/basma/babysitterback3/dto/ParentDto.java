package tn.basma.babysitterback3.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.Parent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@SuperBuilder
public class ParentDto extends RegisterRequest{

    private  String adresse;

    public static Parent toEntity(ParentDto request) {
        return Parent.builder()

                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .sexe(request.getSexe())
                .confirmeMDP(request.getConfirmeMDP())
                .adresse(request.getAdresse())

                .role(request.getRole())
                .build();
    }






}
