package tn.basma.babysitterback3.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "_user")

public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String sexe;
    private String email;
    private String password;
    private String confirmeMDP;
    private int mobile;




    @Builder.Default
    private boolean isEnabled = false;

    @Enumerated(EnumType.STRING)
    private Role role;

//hthya relation bin token wel user
    @JsonIgnore
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Token> tokens;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private  VerificationToken verificationToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


    //hthya relation image hya wel user
    //image

    @OneToOne(mappedBy = "userEntity")
    private Image userImage;

}