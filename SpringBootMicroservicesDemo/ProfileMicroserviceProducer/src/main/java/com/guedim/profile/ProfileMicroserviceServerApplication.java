package com.guedim.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProfileMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileMicroserviceServerApplication.class, args);
	}
}