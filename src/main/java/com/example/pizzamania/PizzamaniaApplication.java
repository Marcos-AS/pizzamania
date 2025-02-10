package com.example.pizzamania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.example.pizzamania.model")
@EnableJpaRepositories("com.example.pizzamania.repositories")
public class PizzamaniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzamaniaApplication.class, args);
	}	
}