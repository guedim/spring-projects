package com.guedim.spring.tick.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/api/people")
	public List<Person> listPeople() {

		delay();
		return getPeople();

	}

	private List<Person> getPeople() {
		Person p1 = new Person("Mario");
		Person p2 = new Person("Yuly");
		Person p3 = new Person("Matías");

		List<Person> people = new ArrayList<>();
		people.add(p1);
		people.add(p2);
		people.add(p3);

		return people;
	}

	private void delay() {
		try {
			Thread.sleep(new Random().nextInt(4) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}