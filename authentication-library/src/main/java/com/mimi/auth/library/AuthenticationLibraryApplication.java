package com.mimi.auth.library;

import com.mimi.auth.library.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackageClasses = UserRepository.class )
public class AuthenticationLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationLibraryApplication.class, args);
	}

}
