package com.myorg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myorg.service.MyService;

@SpringBootApplication
public class SpringBootAopApplication {
	
	@Autowired
	MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}
	
	@Bean
	ApplicationRunner runner() {
		return args -> {
			myService.doService();
		};
	}
}
