package com.guedim.consul.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PricingApplication {
  public static void main(String[] args) {
     SpringApplication.run(PricingApplication.class, args);
  }
}