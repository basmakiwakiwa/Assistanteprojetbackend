package tn.basma.babysitterback3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.basma.babysitterback3.dto.*;
import tn.basma.babysitterback3.entites.*;
import tn.basma.babysitterback3.listener.RegistrationCompleteEvent;
import tn.basma.babysitterback3.repositories.CompetenceRepository;
import tn.basma.babysitterback3.repositories.DiplomeRepository;
import tn.basma.babysitterback3.repositories.TokenRepository;
import tn.basma.babysitterback3.repositories.UserRepository;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static tn.basma.babysitterback3.service.UserService.applicationUrl;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ApplicationEventPublisher publisher;

    private  final DiplomeRepository diplomeRepository;
    private  final CompetenceRepository competenceRepository;

    public Response register(RegisterRequest userRequest, final HttpServletRequest request) {

        boolean userExists = repository.findAll()
                .stream()
                .anyMatch(user -> userRequest.getEmail().equalsIgnoreCase(user.getEmail()));

        if (userExists) {
            return  (Response.builder()
                    .responseMessage("User with provided email  already exists!")
                    .build());
        }

        User user ;
        User savedUser = null ;
        if (userRequest instanceof BabySitterDto ) {
            auxiliairesdevie babySitter =new auxiliairesdevie();
            babySitter = BabySitterDto.toEntity((BabySitterDto)userRequest);
            babySitter.setPassword(passwordEncoder.encode(babySitter.getPassword()));
            babySitter.setConfirmeMDP(passwordEncoder.encode(babySitter.getConfirmeMDP()));
            babySitter.setRole(Role.BABYSITTER);
            //hthya tb3a liste diplome
            List<Long> strDiploms = ((BabySitterDto) userRequest).getIddiplome();
            Set<Diplome> diplomes = new HashSet<>();
            if (strDiploms != null) {
                strDiploms .forEach(id -> {

                    Diplome diplome = (Diplome) diplomeRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Error: diplome is not found."));
                    diplomes.add(diplome);

                });
            }

            babySitter.setDiplomeBabysitter(diplomes);

            //hthya tabda competance
            List<Long> strCompetance = ((BabySitterDto) userRequest).getIddiplome();
            Set<Competence> competences = new HashSet<>();
            if (strCompetance != null) {
                strCompetance .forEach(id -> {

                    Competence competence  = (Competence) competenceRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Error: diplome is not found."));
                    competences.add(competence);

                });
            }

            babySitter.setCompetanceAuxiliairesdevie(competences);
















//toufa lhne methode competance


            var saveUsers = repository.save(babySitter);

            publisher.publishEvent(new RegistrationCompleteEvent(saveUsers, applicationUrl(request)));
            repository.save(babySitter);

            return Response.builder()
                    .responseMessage("register")
                    .email(babySitter.getEmail())
                    .build();
        }




//hthya inscri parent
        if (userRequest instanceof ParentDto ) {
            user =new Parent();
            user = ParentDto.toEntity((ParentDto)userRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmeMDP(passwordEncoder.encode(user.getConfirmeMDP()));
            user.setRole(Role.PARENT);
            var saveUsers = repository.save(user);

            publisher.publishEvent(new RegistrationCompleteEvent(saveUsers, applicationUrl(request)));

            return Response.builder()
                    .responseMessage("register")
                    .email(user.getEmail())
                    .build();
        }


        //hthya inscri admin
        if (userRequest instanceof AdminDeto ) {
            user =new Admin();
            user = AdminDeto.toEntity((AdminDeto)userRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmeMDP(passwordEncoder.encode(user.getConfirmeMDP()));
            user.setRole(Role.ADMIN);
            var saveUsers = repository.save(user);

            publisher.publishEvent(new RegistrationCompleteEvent(saveUsers, applicationUrl(request)));
            repository.save(user);

            return Response.builder()
                    .responseMessage("register")
                    .email(user.getEmail())
                    .build();
        }

        return null;


    }








    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }




    @PostConstruct
    public void createdefeultadm() {
        Admin user =new  Admin();
        User savedUser = null;
        String email = "basmaAdmin@gmail.com";
        if (!repository.existsByEmail(email)) {
            user.setEmail("basmaAdmin@gmail.com");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setConfirmeMDP(new BCryptPasswordEncoder().encode("admin"));
            user.setSexe("famme");
            user.setNom("Admin");
            user.setPrenom("Admin");
            user.setMobile(26278904);
            user.setEnabled(true);
            user.setRole(Role.ADMIN);
            savedUser = repository.save((Admin) user);


        }



    }






}