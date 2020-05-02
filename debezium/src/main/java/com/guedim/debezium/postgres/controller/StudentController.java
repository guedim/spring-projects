package com.guedim.debezium.postgres.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedim.debezium.elasticsearch.model.Student;
import com.guedim.debezium.postgres.repository.StudenRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudenRepository studenRepository;

	public StudentController(StudenRepository studenRepository) {
		this.studenRepository = studenRepository;
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studenRepository.save(student);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student newStudent, @PathVariable String id) {
		return studenRepository.findById(id).map(student -> {
			student.setName(newStudent.getName());
			student.setEmail(newStudent.getEmail());
			student.setAddress(newStudent.getAddress());
			return studenRepository.save(student);
		}).orElseGet(() -> {
			newStudent.setId(id);
			return studenRepository.save(newStudent);
		});
	}

	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable String id) {
		studenRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getUser(@PathVariable("id") String studentId) {
		return ResponseEntity.of(studenRepository.findById(studentId));
	}

}
