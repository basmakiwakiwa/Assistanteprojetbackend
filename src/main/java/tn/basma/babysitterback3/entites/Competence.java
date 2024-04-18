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
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descompetence;


    //hthya relation bin Competance w Assistante
    @JsonIgnore
    @ManyToMany(mappedBy = "CompetanceAuxiliairesdevie", cascade = CascadeType.ALL)
    private Set<auxiliairesdevie> Auxiliairesdevies = new HashSet<>();





}
