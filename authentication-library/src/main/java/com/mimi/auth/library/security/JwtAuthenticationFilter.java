package com.mimi.auth.library.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mimi.auth.library.controller.AuthenticationController;
import com.mimi.auth.library.model.LoginViewModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {
    final static Logger logger  = LogManager.getLogger(AuthenticationController.class);

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager ) {
        this.authenticationManager = authenticationManager;
    }

    /*
    * This method is going to get trigger when we issue POST request /login
    * and we want to pass username and password in the body of header request
    * */
   @Override
    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException {
        // Grab credentials and map them to loginViewmodel
        LoginViewModel loginViewModel = null;
        try {
            // request.getInputStream() is used to get the body of the request. Thus, you will only get the body of the request, not the whole thing. Dans le body nous avons un json avec le username et pass?
           // ObjectMapper class: permet de convertir  une chaine de caractère JSON  en un objet  Java ici LoginviewModel
            loginViewModel = new ObjectMapper().readValue( request.getInputStream(), LoginViewModel.class );
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        /*
            This built token is not the token we are going to return ti the user.
            It will be used by Spring internally to try abd authenticate us by the credentials
            that we provide.
         */

       logger.info( " In authentication filter Username : " + loginViewModel.getUsername() + " password: " + loginViewModel.getPassword());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginViewModel.getUsername(),
                loginViewModel.getPassword(),
                new ArrayList<>());

        // Authenticate user
        /*
        * Based on the authenticationManager, we will try to execute the authentication method with
        * this token and we return the authentication class.
        * */
       Authentication auth = authenticationManager.authenticate( usernamePasswordAuthenticationToken );

        return auth;
    }

    /*
    * If the Authentication was successful, if we manage to authenticate successfully,
    * then this method will be launched.
    * */
    @Override
    protected void successfulAuthentication( HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult ) throws IOException, ServletException {
        // Grab principal
        /*
        * We try to get the userPrincipal instance from the authentication results.
        * We are going to the database to fetch an instance of this class.
        * */
        UserPrincipal userPrincipal = ( UserPrincipal ) authResult.getPrincipal();

        // Create JWT Token
        String token = JWT.create()
                .withSubject( userPrincipal.getUsername() )
                //.withClaim("role", userPrincipal.getRole())
                .withExpiresAt( new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME) )
                .sign( HMAC512( JwtProperties.SECRET.getBytes() ) );
        logger.info( " Token in authentication filter : " + token);


        // Add token in response
        response.addHeader( JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX +  token );
    }
}
