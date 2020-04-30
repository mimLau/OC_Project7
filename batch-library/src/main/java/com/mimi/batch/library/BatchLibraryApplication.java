package com.mimi.batch.library;

import com.mimi.batch.library.mail.Mail;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.mimi.batch.library.proxies")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableBatchProcessing
public class BatchLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchLibraryApplication.class, args);
	}



}
