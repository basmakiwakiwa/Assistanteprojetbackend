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
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Lob // use @Lob annotation to store large binary data
    @Column(name = "picByte", columnDefinition = "LONGBLOB")

    byte[] picByte;



    @OneToOne
    private User userEntity;

}
