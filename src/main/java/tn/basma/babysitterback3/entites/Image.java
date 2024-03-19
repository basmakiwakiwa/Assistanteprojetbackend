package tn.basma.babysitterback3.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String type;

    @Lob // use @Lob annotation to store large binary data
    @Column(name = "picByte", columnDefinition = "LONGBLOB")

    byte[] picByte;



    @OneToOne

    private User userEntity;

}
