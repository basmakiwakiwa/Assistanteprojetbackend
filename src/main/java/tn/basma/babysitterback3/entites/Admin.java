package tn.basma.babysitterback3.entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name = "Admin")
@Entity
@DiscriminatorValue("Admin")
@SuperBuilder
public class Admin extends User{

    private boolean isAdmin;

}
