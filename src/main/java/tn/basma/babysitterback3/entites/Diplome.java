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
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomdiplom;



    //hthya relation bin diplome w babysitter
    @JsonIgnore
    @ManyToMany(mappedBy = "diplomeBabysitter", cascade = CascadeType.ALL)
    private Set<BabySitter> babySitters = new HashSet<>();


}
