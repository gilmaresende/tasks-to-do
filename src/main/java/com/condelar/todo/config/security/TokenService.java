package com.condelar.todo.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.condelar.todo.app.entity.Login;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Login usuario) {
        return JWT.create().withIssuer("login").withSubject(usuario.getUsername()).withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10L).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("secreta"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta")).withIssuer("login").build().verify(token).getSubject();
    }

}
