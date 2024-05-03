package tn.basma.babysitterback3.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import tn.basma.babysitterback3.entites.AnnonceParent;
import tn.basma.babysitterback3.repositories.ServiceAssistanteRepository;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class AnnonceDeto {


    private Long idAnnonceParent;
    private String titreannonce;
    private String description;
    private int nombreEnfants;
    private Date datedebut;
    private Date datefin;
    private int budget;
    private String emplacement;
    private String languesparlees;
    private int agedesenfants;
    private Long idservice;



    @Autowired
    private static ServiceAssistanteRepository serviceAssistanteRepository;

    public static AnnonceParent toEntity(AnnonceDeto request) {



        return AnnonceParent .builder()
                .titreannonce(request.getTitreannonce())
                .description(request.getDescription())
                .nombreEnfants(request.getNombreEnfants())
                .datedebut(request.getDatedebut())
                .datefin(request.getDatefin())
                .budget(request.getBudget())
                .emplacement(request.getEmplacement())
                .languesparlees(request.getLanguesparlees())
                .agedesenfants(request.getAgedesenfants())

                .build();
    }



}
