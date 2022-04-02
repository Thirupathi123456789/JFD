package com.deploy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class AppDeployOnCloudApplication {
	
	@GetMapping("/test")
	public String home() {
		return "Welcome to AWS First Deployment...";
	}


	public static void main(String[] args) {
		SpringApplication.run(AppDeployOnCloudApplication.class, args);
	}

}
