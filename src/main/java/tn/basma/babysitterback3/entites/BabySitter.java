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
public class BabySitter extends User {

    private String  description;
    private Date    dateN;
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
    private DisponibiliteBabysitter disponibilitebabysitter;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "BabysitterDiplome", joinColumns =@JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "iddip"))
    private Set<Diplome> diplomeBabysitter ;


    //hthya relationmanytomany m3a competance

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "BabysitterCompetance", joinColumns =@JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "idcompetance"))
    private Set<Competence> competanceBabysitter ;






}
