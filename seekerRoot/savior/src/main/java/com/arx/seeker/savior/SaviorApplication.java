package com.arx.seeker.savior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.arx.seeker.savior.steps.Starter;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SaviorApplication {
	@Autowired
	Starter starter;


	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SaviorApplication.class, args);
		Starter starter=ctx.getBean(Starter.class);
		starter.start();
	}


	
}
