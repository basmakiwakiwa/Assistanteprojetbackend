package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity

public class AnnonceParent {

    //IDENTITY manha a chaque fois bch yatik valeur 1.2.3..


    //bhy besba lil implementation fi daigramme de classe 3ana 2 etape etape lwla nhkiou ala implementation mech relation rana
    // bhy etape lawla implementation des entites 2eme etape hya implementation de relation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonceParent;
    private String titreannonce;
    private String description;
    private int nombreEnfants;
    private Date datedebut;
    private Date datefin;
    private int budget;
    private String emplacement;
    private String languesparlees;
    private int agedesenfants;







    // hthya relation ManyToOne eli mn table annonnce parent l table parent
    //lhne bch nista3mlou JoinColumn hthya lezmna namlouha bch t3awna fil party base de donne
    //bhy fetch 3ana zouz anwa3 par exemple fetch Eager hya imediatement mithel manytoone  tab3th requete immediatement lazy 3ibara bch ngoula stana raw thama hajet 9ablek raw thme relationete 9ablk
    //bhy alch nista3mlou fha nista3mlou faha khter ahna par exemple fil diagramme de classe mta3na 3ana parent bhy awel haja najmou nista3mlouha kima mnjmouch
    //@JoinColumn(name="parent_id") lhne 7atina id mta3 parent eli inserha donc fil base de donne bch ywali 3ana attribute parent_id hwa parent eli inserha

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;










}




