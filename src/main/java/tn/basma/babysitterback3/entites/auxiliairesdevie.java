package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@SuperBuilder
public class auxiliairesdevie extends User {

    private String  description;
    private Date    dateN;
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

//hthya relation bin baby siter w dispo
@JsonIgnore
    @OneToOne(mappedBy = "Babysitter")
    private DisponibiliteBabysitter disponibilitebabysitter;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "auxiliairesdevieDiplome", joinColumns =@JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "iddip"))
    private Set<Diplome> diplomeBabysitter ;


    //hthya relation bin comp w auxiliairesdevie

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "AuxiliairesdevieCompetance")
    private Set<Competence> CompetanceAuxiliairesdevie;


//hthya relation manytomany m3a activite
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "AuxiliairesdevieActivites")
    private Set<Activites> ActivitesAuxiliairesdevie;







}
