package tn.basma.babysitterback3.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.BabySitter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@SuperBuilder
public class BabySitterDto extends RegisterRequest{

    private String  description;
    private Date dateN;
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

    private List<Long> iddiplome;
    private List<Long> idcompetance;

    public static BabySitter toEntity(BabySitterDto request) {
        return BabySitter.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .sexe(request.getSexe())
                .confirmeMDP(request.getConfirmeMDP())
                .description(request.getDescription())
                .dateN(request.getDateN())

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
