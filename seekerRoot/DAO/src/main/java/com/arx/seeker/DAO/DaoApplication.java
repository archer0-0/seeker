package com.arx.seeker.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class DaoApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DaoApplication.class);
	
	
	public static void main(String[] args) {
		System.out.println("Hola");
		SpringApplication springApplication= new SpringApplication(DaoApplication.class);
		springApplication.setBannerMode(Mode.OFF);
		springApplication.run(DaoApplication.class, args);
		

	
		
	}
	
}
