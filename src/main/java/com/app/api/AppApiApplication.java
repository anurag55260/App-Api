package com.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//Anurag
@EnableJpaRepositories(basePackages = "com.app.api.repository")
@SpringBootApplication
public class AppApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}
}
