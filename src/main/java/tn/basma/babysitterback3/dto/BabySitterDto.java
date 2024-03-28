package tn.basma.babysitterback3.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.Babysitter;
import tn.basma.babysitterback3.entites.Parent;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@SuperBuilder
public class BabySitterDto extends RegisterRequest{

    private String  description;
    private Date dateN;
    private String  Statutmarital;
    private int     budget;
    private String  dispo;
    private String  langues;
    private String  competences;
    private String  piecejustificative;
    private String  experience;
    private String  adresse;
    private int     CIN;
    private String  etatcivil;
    private String  niveaudeetude;


    public static Babysitter toEntity(BabySitterDto request) {
        return Babysitter.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .sexe(request.getSexe())
                .confirmeMDP(request.getConfirmeMDP())
                .description(request.getDescription())
                .dateN(request.getDateN())
                .Statutmarital(request.getStatutmarital())
                .budget(request.getBudget())
                .dispo(request.getDispo())
                .langues(request.getLangues())
                .competences(request.getCompetences())
                .piecejustificative(request.getPiecejustificative())
                .experience(request.getExperience())
                .adresse(request.getAdresse())
                .CIN(request.getCIN())
                .etatcivil(request.getEtatcivil())
                .niveaudeetude(request.getNiveaudeetude())

                .role(request.getRole())
                .build();
    }


}
