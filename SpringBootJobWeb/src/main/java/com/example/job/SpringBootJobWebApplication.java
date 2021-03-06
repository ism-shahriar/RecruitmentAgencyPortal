package com.example.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootJobWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJobWebApplication.class, args);
		System.out.println("Spring Boot Job Web Portal Started!!");

	}

}
