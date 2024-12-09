package com.eduardocruzdev.med_voll.infra.security;

import com.auth0.jwt.JWT;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eduardocruzdev.med_voll.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${JWT_SECRET:123456}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);


        } catch (JWTVerificationException exception) {
            throw new RuntimeException(exception);
        }

    }

    public String getSubject(String token) {
if ( token == null ) {
    throw new RuntimeException("No se encontro el token");
}
        DecodedJWT verifier = null;

        try{
        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        verifier = JWT.require(algorithm)
                .withIssuer("voll med")
                .build()
                .verify(token);
            verifier.getSubject();
    }catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if(verifier.getSubject() == null){
            throw new RuntimeException("No se encontro el token");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
