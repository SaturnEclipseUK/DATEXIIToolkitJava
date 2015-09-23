package com.se.datex2clienttoolkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class Datex2ClientToolkitApplication {

	@SuppressWarnings("resource")
    public static void main(String[] args) {
        SpringApplication.run(Datex2ClientToolkitApplication.class, args);        
    }
}
