package tn.basma.babysitterback3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.dto.*;
import tn.basma.babysitterback3.entites.User;
import tn.basma.babysitterback3.repositories.listParentRepo;
import tn.basma.babysitterback3.service.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register/Parent")
    public Response register(
            @RequestBody @Valid ParentDto userRequest,
            HttpServletRequest request
    )  {
        return service.register(userRequest,request);
    }


    @PostMapping("/register/babysitter")
    public Response register(
            @RequestBody @Valid BabySitterDto userRequest,
            HttpServletRequest request
    )  {
        return service.register(userRequest,request);
    }
    @PostMapping("/register/Admin")
    public Response register(
            @RequestBody @Valid AdminDeto userRequest,
            HttpServletRequest request
    )  {
        return service.register(userRequest,request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}