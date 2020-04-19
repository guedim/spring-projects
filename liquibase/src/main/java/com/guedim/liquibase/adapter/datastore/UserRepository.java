package com.guedim.liquibase.adapter.datastore;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guedim.liquibase.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
