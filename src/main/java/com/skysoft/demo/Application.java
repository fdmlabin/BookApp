package com.skysoft.demo;


import com.skysoft.demo.domain.Author;
import com.skysoft.demo.services.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(AuthorService authorService){
		return args ->{
			Author author = new Author();

			author.setNom("Francis");
			author.setTel(656413445);
			author.setAdresse("Douala, Bonamoussadi");
			author.setBirthdate(LocalDate.now());
			authorService.save(author);
		};
	}

}
