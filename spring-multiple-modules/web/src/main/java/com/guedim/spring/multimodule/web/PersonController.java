package com.guedim.spring.multimodule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedim.spring.multimodule.repo.Person;
import com.guedim.spring.multimodule.service.IPersonService;

@RestController
public class PersonController {

	@Autowired
	private IPersonService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/person")
	public List<Person> findAll() {
		return service.findAll();
	}

	
}