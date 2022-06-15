package com.app.nsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MyAppConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppConsumerServiceApplication.class, args);
		System.out.println("Consumer Service Started ...");
	}

}
