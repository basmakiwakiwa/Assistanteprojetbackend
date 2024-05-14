package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

    private String  experience;
    private String  adresse;
    private int     cin;
    private String  etatcivil;
    private String  niveaudeetude;
    private String  image;
    private List<Long> iddiplome;
    private List<Long> idcompetance;
    private List<Long> idActivite;




    @ManyToMany
    @JoinTable(name = "auxiliairesdevieDiplome", joinColumns =@JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "iddip"))
    private Set<Diplome> diplomeBabysitter ;


    //hthya relation bin comp w auxiliairesdevie


    @ManyToMany
    @JoinTable(name = "AuxiliairesdevieCompetance")
    private Set<Competence> CompetanceAuxiliairesdevie;


//hthya relation manytomany m3a activite

    @ManyToMany
    @JoinTable(name = "AuxiliairesdevieActivites")
    private Set<Services> ActivitesAuxiliairesdevie;





    @JsonIgnore
    @OneToMany(mappedBy = "auxiliairesdevies", cascade = CascadeType.ALL)
    private Set<Rdv> rdvs = new HashSet<>();



}
