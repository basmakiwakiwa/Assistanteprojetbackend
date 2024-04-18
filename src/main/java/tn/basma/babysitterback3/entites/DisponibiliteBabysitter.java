package tn.basma.babysitterback3.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

@Entity
public class DisponibiliteBabysitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idDispo;


//lhne ene bch naml relation binn baby sitter wel disponibilite

    @OneToOne

    private auxiliairesdevie Babysitter;

}
