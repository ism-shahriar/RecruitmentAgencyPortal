package com.spring.mysql.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceJobCatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceJobCatApplication.class, args);
		System.setProperty("spring.config.name", "microservicejobcat-web");
		System.out.println("Spring Boot Job Category Web Portal Started!!");
	}

}
