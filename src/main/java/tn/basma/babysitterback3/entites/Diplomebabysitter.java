package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Entity
public class Diplomebabysitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //hthya relation bin diplome w babysiter

    @ManyToMany
    Set<Babysitter> babysitters;


}
