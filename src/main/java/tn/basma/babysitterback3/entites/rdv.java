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
public class rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_rdv;
    private  String description;
    private  String etatrdv;
    private  String fixepar;


//hthya relation bin rdv wel parent
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;




}
