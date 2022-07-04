package br.edu.univas.si7.LeonardoHenrique;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LeonardoHenriqueApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(LeonardoHenriqueApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
