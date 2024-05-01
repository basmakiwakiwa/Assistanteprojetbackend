package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Entity
public class Activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Designation;
    private String  description;


    //mezelet relation


    //hthya relation bin Competance w Assistante
    @JsonIgnore
    @ManyToMany(mappedBy = "ActivitesAuxiliairesdevie", cascade = CascadeType.ALL)
    private Set<auxiliairesdevie> Auxiliairesdeviess = new HashSet<>();













}



