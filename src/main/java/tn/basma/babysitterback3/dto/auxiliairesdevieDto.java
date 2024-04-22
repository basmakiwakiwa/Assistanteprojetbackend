package tn.basma.babysitterback3.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tn.basma.babysitterback3.entites.auxiliairesdevie;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@SuperBuilder
public class auxiliairesdevieDto extends RegisterRequest{

    private String  description;
    private Date dateN;
    private int     budget;
    private String  dispo;
    private String  langues;

    private String  piecejustificative;
    private String  experience;
    private String  adresse;
    private int     cin;
    private String  etatcivil;
    private String  niveaudeetude;
    private String  image;

    private List<Long> iddiplome;
    private List<Long> idcompetance;
    private List<Long> idActivite;


    public static auxiliairesdevie toEntity(auxiliairesdevieDto request) {
        return auxiliairesdevie.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(request.getPassword())
                .sexe(request.getSexe())
                .confirmeMDP(request.getConfirmeMDP())
                .description(request.getDescription())
                .dateN(request.getDateN())
                .image(request.getImage())
                .budget(request.getBudget())
                .dispo(request.getDispo())
                .langues(request.getLangues())






                .piecejustificative(request.getPiecejustificative())
                .experience(request.getExperience())
                .adresse(request.getAdresse())
                .cin(request.getCin())
                .etatcivil(request.getEtatcivil())
                .niveaudeetude(request.getNiveaudeetude())



                .role(request.getRole())

                .build();
    }





}
