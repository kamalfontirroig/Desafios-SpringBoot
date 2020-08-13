package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoticiasApplication {

	
	private static final Logger log = LoggerFactory.getLogger(NoticiasApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NoticiasApplication.class, args);
		log.error("nub");
		log.warn("manco");
	}

}
