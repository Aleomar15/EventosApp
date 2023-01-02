package com.CursoSpring.Aplicacao1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Aplicacao1Application {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacao1Application.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
