package com.mimi.auth.library.security;

import com.mimi.auth.library.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;
    private UserRepository userRepository;

    public WebSecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository ) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider( authenticationProvider() );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
            .and( )
            .addFilter( new JwtAuthorizationFilter( authenticationManager() , this.userRepository))
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated();
    }



    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder( passwordEncoder() );
        daoAuthenticationProvider.setUserDetailsService( this.userPrincipalDetailsService );

        return daoAuthenticationProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
