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
public class RdvParent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_rdv;
    private  String description;
    private String etatrdv ;
    private String roleRDV;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;




    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idauxiliaires")
    private auxiliairesdevie  auxiliairesdevies;



}
