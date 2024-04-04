package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Entity
@DiscriminatorValue("babysitter")
@SuperBuilder
public class Babysitter extends User {

    private String  description;
    private Date    dateN;
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



//hthya relation bin baby siter w dispo

    @OneToOne(mappedBy = "Babysitter")
    private Disponibilitebabysitter disponibilitebabysitter;

    //hthya relation bin babysitter wel competance

    @ManyToMany
    Set<competence> comp;

//hthya relation bin babysitter w diplome

    @ManyToMany
    Set<Diplomebabysitter> diplomebabysitters;


}
