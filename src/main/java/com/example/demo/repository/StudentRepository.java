package com.example.demo.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface StudentRepository extends MongoRepository<Student, Long>{
	
	Optional<Student> findStudentByEmail(String email);

}
