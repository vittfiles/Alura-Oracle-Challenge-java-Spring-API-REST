package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.session.DataCreateSession;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.session.SessionDTO;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.User;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserCreatedDTO;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SessionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<UserCreatedDTO> createSession(@RequestBody @Valid DataCreateSession data){
        Authentication authData = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        var userAuthenticated = authenticationManager.authenticate(authData);
        var tokenJWT = tokenService.generateToken((User) userAuthenticated.getPrincipal());

        UserCreatedDTO userCreatedDTO = new UserCreatedDTO(
                tokenJWT,
                "Bearer ",
                (User) userAuthenticated.getPrincipal()
        );
        return ResponseEntity.ok(userCreatedDTO);
//        return ResponseEntity.ok(new SessionDTO(tokenJWT,"Bearer "));
    }
}
