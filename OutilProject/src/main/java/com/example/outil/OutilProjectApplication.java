package com.example.outil;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OutilProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OutilProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
