package tn.basma.babysitterback3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.basma.babysitterback3.dto.*;
import tn.basma.babysitterback3.service.InscriptionService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class InscriptionController {

    private final InscriptionService service;

    @PostMapping("/register/Parent")
    public Response register(
            @RequestBody @Valid ParentDto userRequest,
            HttpServletRequest request
    )  {
        return service.register(userRequest,request);
    }


    @PostMapping("/register/assistante")
    public Response register(
            @RequestBody @Valid auxiliairesdevieDto userRequest,
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