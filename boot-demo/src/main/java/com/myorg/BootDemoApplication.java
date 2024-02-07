package com.myorg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myorg.components.EmailClient;

@SpringBootApplication
public class BootDemoApplication {

	@Autowired
	EmailClient emailClient;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return args -> {
			emailClient.sendEmail();
		};
	}
}
