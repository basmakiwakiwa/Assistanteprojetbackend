package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "Parent")
@SuperBuilder
@Entity
@DiscriminatorValue("Parent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Parent extends User {
//hthya zeyda
    private  String adresse;


    //hthya relation bin parent wel annonce eli bch yhabtha
    //mappedBy  manhha annonce ethya chkoun eli bch ymleha
    //cascade all mannhha kn bch nfas5ou haja raw bch yfas5hom lkoul
    @JsonIgnore
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private Set<AnnonceParent> annonceParents = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<RdvParent> rdvs = new HashSet<>();




    @JsonIgnore
    @OneToMany(mappedBy = "auxiliairesdevies", cascade = CascadeType.ALL)
    private Set<Rdvauxiliaires> rdvss = new HashSet<>();




}
