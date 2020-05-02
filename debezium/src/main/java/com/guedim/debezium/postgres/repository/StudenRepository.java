package com.guedim.debezium.postgres.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.guedim.debezium.elasticsearch.model.Student;

public interface StudenRepository extends JpaRepository<Student, String> {
}