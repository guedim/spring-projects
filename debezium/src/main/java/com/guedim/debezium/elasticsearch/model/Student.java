package com.guedim.debezium.elasticsearch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ElasticSearch Student entity
 */
@Data
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	private String id;

	private String name;

	private String address;

	private String email;
}
