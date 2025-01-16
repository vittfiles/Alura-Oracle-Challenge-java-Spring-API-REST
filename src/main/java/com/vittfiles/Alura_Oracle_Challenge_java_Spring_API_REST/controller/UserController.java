package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.DataCreateUser;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.User;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserCreatedDTO;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.infra.security.TokenService;
import jakarta.validation.Valid;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid DataCreateUser data){
        try {
            User user = userRepository.save(new User(data,passwordEncoder));
            var tokenJWT = tokenService.generateToken(user);
            UserCreatedDTO userCreatedDTO = new UserCreatedDTO(
                    tokenJWT,
                    "Bearer ",
                    user
            );
            return ResponseEntity.ok(userCreatedDTO);
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("El email ya existe");
        }
    }
}
