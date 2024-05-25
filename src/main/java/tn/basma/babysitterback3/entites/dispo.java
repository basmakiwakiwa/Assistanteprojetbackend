package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Entity
public class dispo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean Lundi;
    private boolean Mardi;
    private boolean Mercredi;
    private boolean Jeudi;
    private boolean Vendredi;
    private boolean Samedi;
    private boolean Dimanche;
    private boolean matin ;
    private boolean ap_midi;
    private boolean tard_ap_midi;
    private boolean soir;

    @JsonIgnore
    @OneToOne
    private auxiliairesdevie auxiliairesdeviesss;


}
