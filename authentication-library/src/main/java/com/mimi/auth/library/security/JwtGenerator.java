package com.mimi.auth.library.security;

import com.auth0.jwt.JWT;
import com.mimi.auth.library.model.LoginViewModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Component
public class JwtGenerator {

    final static Logger logger  = LogManager.getLogger( JwtGenerator.class );
    private AuthenticationManager authenticationManager;

    public JwtGenerator( AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    public String generate( LoginViewModel viewModel, HttpServletResponse response ) {

        Authentication auth;
        String token;

        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    viewModel.getUsername(),
                    viewModel.getPassword(),
                    new ArrayList<>());

            auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            logger.info(" In jwtGenerator Username: " + viewModel.getUsername() + " password: " + viewModel.getPassword());

            UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();

            // Create JWT Token
            token = JWT.create()
                    .withSubject(userPrincipal.getUsername())
                    .withClaim("role", "ROLE_" + userPrincipal.getRole())
                    .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                    .sign(HMAC512(JwtProperties.SECRET.getBytes()));

            token = JwtProperties.TOKEN_PREFIX + token;
            response.addHeader(JwtProperties.HEADER_STRING,  token);

            logger.error(" Token in authcontroller in server auth : " + token);

        } catch (BadCredentialsException e) {
            //throw new Exception("Identifiant ou mot de passe incorrect", e);
            logger.error("Identifiant ou mot de passe incorrect");
            return null;
        }

        return token;
    }
}
