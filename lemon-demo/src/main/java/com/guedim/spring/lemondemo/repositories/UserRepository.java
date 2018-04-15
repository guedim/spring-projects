package com.guedim.spring.lemondemo.repositories;

import com.guedim.spring.lemondemo.domain.User;
import com.naturalprogrammer.spring.lemon.domain.AbstractUserRepository;

public interface UserRepository extends AbstractUserRepository<User, Long> {

}