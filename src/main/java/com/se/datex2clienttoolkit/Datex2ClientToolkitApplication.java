package com.se.datex2clienttoolkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * Main spring boot application
 * 
 * @author Saturn Eclipse Limited
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class Datex2ClientToolkitApplication {

	@SuppressWarnings("resource")
    public static void main(String[] args) {
        SpringApplication.run(Datex2ClientToolkitApplication.class, args);        
    }
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
	    return builder;
	}
	
}
