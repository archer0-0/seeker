package com.arx.seeker.DAO.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="application.properties")
public class Properties {
	@Value("${propertyTest}")
	private String textDeEjemplo;
	
	
	
	public String getTextDeEjemplo() {
		return textDeEjemplo;
	}

	public void setTextDeEjemplo(String textDeEjemplo) {
		this.textDeEjemplo = textDeEjemplo;
	}
	
	

}
