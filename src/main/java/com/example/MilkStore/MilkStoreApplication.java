package com.example.MilkStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MilkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilkStoreApplication.class, args);
	}

}
