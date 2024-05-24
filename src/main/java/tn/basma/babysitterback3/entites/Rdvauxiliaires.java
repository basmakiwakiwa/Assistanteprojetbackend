package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Rdvauxiliaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_rdvauxiliaires;
    private  String description;
    private String etatrdv ;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auxiliairesdevie_id")
    private auxiliairesdevie  auxiliairesdevies;




    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idparent")
    private  Parent parent;


}
