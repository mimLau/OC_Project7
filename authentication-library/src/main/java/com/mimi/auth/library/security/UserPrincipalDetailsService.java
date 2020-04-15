package com.mimi.auth.library.security;

import com.mimi.auth.library.model.User;
import com.mimi.auth.library.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        //return new MyUserDetails( username );
        Optional<User> user = userRepository.findByUsername( username );
        user.orElseThrow( ()-> new UsernameNotFoundException( "Not found: " + username ));

        //UserPrincipal userPrincipal = new UserPrincipal( user.get());

        return user.map( UserPrincipal::new ).get();
    }
}
