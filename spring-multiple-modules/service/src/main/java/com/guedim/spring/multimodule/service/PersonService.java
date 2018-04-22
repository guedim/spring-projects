package com.guedim.spring.multimodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.guedim.spring.multimodule.repo.Person;
import com.guedim.spring.multimodule.repo.PersonRepository;

public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository repository;
	
	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

}
