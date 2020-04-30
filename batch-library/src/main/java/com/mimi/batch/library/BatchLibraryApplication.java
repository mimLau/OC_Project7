package com.mimi.batch.library;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@EnableFeignClients("com.mimi.batch.library.proxies")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableBatchProcessing
public class BatchLibraryApplication {

	/*@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(BatchLibraryApplication.class, args);
	}



}
