package com.guedim.spring.multimodule.service;

import java.util.List;

import com.guedim.spring.multimodule.repo.Person;


public interface IPersonService {

	List<Person> findAll();
}
