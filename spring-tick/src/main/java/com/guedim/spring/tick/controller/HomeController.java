package com.guedim.spring.tick.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
    public String index() {
		delay();
        return "Greetings from Spring Boot!";
    }

	private void delay() {
		try {
			Thread.sleep(new Random().nextInt(4) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}