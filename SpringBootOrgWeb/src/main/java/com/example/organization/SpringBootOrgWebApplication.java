package com.example.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootOrgWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrgWebApplication.class, args);
		System.out.println("Spring Boot Organization Web Portal Started!!");

	}

}
