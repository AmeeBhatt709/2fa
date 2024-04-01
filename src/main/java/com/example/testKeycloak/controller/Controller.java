package com.example.testKeycloak.controller;

import com.example.testKeycloak.auth.AuthenticationService;
import com.example.testKeycloak.dto.AuthenticationRequest;
import com.example.testKeycloak.dto.AuthenticationResponse;
import com.example.testKeycloak.dto.RegisterRequest;
import com.example.testKeycloak.dto.VerificationRequest;
import com.nimbusds.jose.shaded.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
//@SecurityRequirement(name = "keycloak")
@RequiredArgsConstructor
public class Controller {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {

        var response=authenticationService.register(request);
    //        String base64Image = response.getSecretString().replaceFirst("data:", "");
//
//        response.setSecretString(base64Image);
        System.out.println("response.getSecretString() = " + response.getSecretString());
//        System.out.println("new Gson().toJson(response) = " + new Gson().toJson(response));

        if(request.isMfaEnabled())
        {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(
            @RequestBody VerificationRequest verificationRequest
    )
    {
        return ResponseEntity.ok(authenticationService.verifyCode(verificationRequest));
    }
}
