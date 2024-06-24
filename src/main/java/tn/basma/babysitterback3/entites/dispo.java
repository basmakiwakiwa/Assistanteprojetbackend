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
public class dispo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Lundi;
    private String Mardi;
    private String Mercredi;
    private String Jeudi;
    private String Vendredi;
    private String Samedi;
    private String Dimanche;
    private String matin;
    private String ap_midi;
    private String tard_ap_midi;
    private String soir;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auxiliairesdevie_id")
    private auxiliairesdevie  auxiliairesdevies;



}
