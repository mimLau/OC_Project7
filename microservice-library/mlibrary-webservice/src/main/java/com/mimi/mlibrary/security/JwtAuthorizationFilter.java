package com.mimi.mlibrary.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    final static Logger logger  = LogManager.getLogger( JwtAuthorizationFilter.class );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // 1. Check for token in request
        String token = request.getHeader( JwtProperties.HEADER_STRING );
        logger.info( " Token in doFilter in microservice: " + token );

        // 2. If there is no token the user won't be authenticated.
        if(token == null) {
            chain.doFilter(request, response);
            return;
        }

        try {

            token = token.replace(JwtProperties.TOKEN_PREFIX,"");

            logger.info( " Token in doFilter in microservice: " + token );
            // 4. Validate the token
            DecodedJWT jwt = JWT.require( HMAC512( JwtProperties.SECRET.getBytes()) )
                    .build()
                    .verify(token);

            String username = jwt.getSubject();
            if(username != null) {

                //Try to get list<GrantedAuthority from claim object in token
                String claimToString = jwt.getClaim("role").asString();
                logger.info( " claimToString  in microservice: " + claimToString );
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

                if (claimToString.length() > 0)
                    grantedAuthorities.add(new SimpleGrantedAuthority(claimToString));

                for(GrantedAuthority gr : grantedAuthorities )
                    logger.info( "\n grantedAuthorities  in microservice: " + gr );


                // 5. Create auth object
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, grantedAuthorities);

                // 6. Authenticate the user
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            // In case of failure. Make sure user won't be authenticated
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }
}
