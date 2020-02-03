package com.payulatam.pmequalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.payulatam.pmequalizer.repositories")
@EntityScan("com.payulatam.pmequalizer.model")
public class PmEqualizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmEqualizerApplication.class, args);
	}

}
