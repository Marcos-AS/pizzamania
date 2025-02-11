package com.example.pizzamania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.pizzamania.entities")
@EnableJpaRepositories("com.example.pizzamania.repositories")
@ComponentScan("com.example.pizzamania")
public class PizzamaniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzamaniaApplication.class, args);
	}	
}