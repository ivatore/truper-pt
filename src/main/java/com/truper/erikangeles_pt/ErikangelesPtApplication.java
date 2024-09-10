package com.truper.erikangeles_pt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ErikangelesPtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErikangelesPtApplication.class, args);
	}

}
