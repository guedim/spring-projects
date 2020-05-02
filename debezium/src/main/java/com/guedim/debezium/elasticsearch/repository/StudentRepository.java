package com.guedim.debezium.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.guedim.debezium.elasticsearch.model.Student;

/**
 * This interface provides handles to database, to perform CRUD operations on the index `STUDENT`.
 * The index is represented by the JPA entity {@link Student}.
 *
 * @author Sohan
 * @see ElasticsearchRepository
 */
//@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Integer> {
}