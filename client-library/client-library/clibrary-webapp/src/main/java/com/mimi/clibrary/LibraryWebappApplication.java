package com.mimi.clibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.mimi.clibrary.proxies")
public class LibraryWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryWebappApplication.class, args);
	}

}
