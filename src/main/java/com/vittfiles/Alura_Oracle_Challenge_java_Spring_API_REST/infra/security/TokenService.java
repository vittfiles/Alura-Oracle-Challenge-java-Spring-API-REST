package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                .withIssuer("challenge")
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token){
        if(token == null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("challenge")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }
        if(verifier == null || verifier.getSubject() == null){
            throw new RuntimeException("Verifier inválido");
        }
        return verifier.getSubject();
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}

