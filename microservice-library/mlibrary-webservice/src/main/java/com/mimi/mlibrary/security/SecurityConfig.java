package com.mimi.mlibrary.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
            .and()
            .authorizeRequests()
                .antMatchers("/Members/**").permitAll()
                .antMatchers("/Copies/**").permitAll()
                .antMatchers("/Libraries/**").permitAll()
                .antMatchers("/Publications/**").permitAll()
                .antMatchers("/Borrowings/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

}
