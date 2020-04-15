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
            //.addFilter( new JwtAuthenticationFilter( authenticationManager() ) )
            .addFilter( new JwtAuthorizationFilter( authenticationManager() , this.userRepository))
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            /*.antMatchers("/manager/**").authenticated()
            .antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")*/
            .anyRequest().authenticated();

            //http.addFilterAfter( new JwtAuthorizationFilter( authenticationManager() , this.userRepository) , UsernamePasswordAuthenticationFilter.class); //Utiliser notre filtre avant le  UsernamePasswordAuthenticationFilter qui est utilisé par défaut dans Spring


        /*http.addFilter( new JwtAuthenticationFilter( authenticationManager() ) );
        http.addFilterBefore( new JwtAuthorizationFilter( this.userRepository ), UsernamePasswordAuthenticationFilter.class );*/

        // Add JWT filters
        //.addFilter( new JwtAuthenticationFilter( authenticationManager() ) )
            // remove csrf and state in session because in jwt we do not need them
            /*.csrf().disable()
            .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
            .and()
            // Add JWT filters
            /*.addFilter( new JwtAuthenticationFilter( authenticationManager() ) )
            .addFilter( new JwtAuthorizationFilter( authenticationManager() , this.userRepository ))
            .authorizeRequests()
            //configure access rules
            .antMatchers(HttpMethod.OPTIONS, "/login" ).permitAll()
            .antMatchers("/api/public/admin/*").hasRole("ADMIN");
            //.antMatchers("/index.html").permitAll()
            //.antMatchers("/profile/**").authenticated()
            //.antMatchers("/admin/**").hasRole("ADMIN")
            //.antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
            //.antMatchers("/Members").hasAuthority("ACCESS_USER")
            //
            //.antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
            //.antMatchers("/api/public/users").hasRole("ADMIN");
            /*.and()
            .formLogin()
            .loginProcessingUrl("/signin")
            .loginPage("/login").permitAll()
            .usernameParameter("txtUsername")
            .passwordParameter("txtPassword");
            /*.and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
            /*.and()
            .rememberMe().tokenValiditySeconds(2592000).key("mySecret!").rememberMeParameter("checkRememberMe");*/
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
