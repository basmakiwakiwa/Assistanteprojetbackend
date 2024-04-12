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

    private Long idComp;
    private  String nomComp;

//hthya relation  manytomany bin comp wel babysitter

    @JsonIgnore
    @ManyToMany(mappedBy = "competanceBabysitter")
    private Set<BabySitter> babySitters = new HashSet<>();


}
