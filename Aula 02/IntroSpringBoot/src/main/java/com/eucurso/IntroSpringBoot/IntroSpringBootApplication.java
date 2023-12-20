package com.eucurso.IntroSpringBoot;

import com.eucurso.IntroSpringBoot.model.Livro;
import com.eucurso.IntroSpringBoot.repository.LivroRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class IntroSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringBootApplication.class, args);
	}
}
