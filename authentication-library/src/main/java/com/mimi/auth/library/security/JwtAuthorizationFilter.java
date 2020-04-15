package com.mimi.auth.library.security;

import com.auth0.jwt.JWT;
import com.mimi.auth.library.controller.AuthenticationController;
import com.mimi.auth.library.model.User;
import com.mimi.auth.library.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    final static Logger logger  = LogManager.getLogger( JwtAuthorizationFilter.class );

    /*To extract from him the userDetails based on the username
    that we read from the token that we received.*/
    private UserRepository userRepository;

    public JwtAuthorizationFilter( AuthenticationManager authenticationManager, UserRepository userRepository ) {
        super( authenticationManager );
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain chain ) throws IOException, ServletException {
        // Read the Authorization header, where the JWT token should be
        String header = request.getHeader( JwtProperties.HEADER_STRING );

        logger.error("Header auth server: " + header );

        // If header does not contain TOKEN PREFIX  or is null delegate to Spring impl and exit
        if ( header == null || !header.startsWith( JwtProperties.TOKEN_PREFIX ) ) {
            chain.doFilter(request, response);
            return;
        }

        try {
            // If header is present, try grab user principal from database and perform authorization
            // et si le mot de passe ne correspond à ce qu'il y a dans la BDD?
            Authentication authentication = getUsernamePasswordAuthentication(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
        // In case of failure. Make sure user won't be authenticated
        SecurityContextHolder.clearContext();
    }
        // Continue filter execution
        chain.doFilter( request, response );
    }

    private Authentication getUsernamePasswordAuthentication( HttpServletRequest request ) {
        String token = request.getHeader( JwtProperties.HEADER_STRING )
                .replace(JwtProperties.TOKEN_PREFIX,""); //On supprime le suffixe Baerer du token

        logger.info( " In authorization filter token : " + token);

        if ( token != null ) {
            // parse the token and validate it. Decode the token
            String username = JWT.require( HMAC512(JwtProperties.SECRET.getBytes()) )
                    .build()
                    .verify( token )
                    .getSubject(); //On récupère le subject du JWT qui est le  username




            // Search in the DB if we find the user by token subject (username)
            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
            if ( username != null ) {
                User user = userRepository.findByUsername( username ).get();
                UserPrincipal principal = new UserPrincipal( user ); //On crée le userPrincipal à partir de l'user récupéré en BDD.
                //Création d'un usernamePassAuthToken à partir du userPrincipal et on autorise l'authentification
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken( username, null, principal.getAuthorities() );
                return auth;
            }
            return null;
        }
        return null;
    }
}
