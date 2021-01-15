package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email already registered");
		}
		
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		boolean exists =  studentRepository.existsById(id);
		
		if (!exists) {
			throw new IllegalStateException("student does not exist");
		}
		studentRepository.deleteById(id);
		
	}

	public void updateStudent(Long id, String name, String email) {
		boolean exists =  studentRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("student does not exist");
		}
		
		Student student = studentRepository.findById(id)
				.orElseThrow(()-> new IllegalStateException("cannot find student"));
		if (name != null) {
			student.setName(name);
		}
		
		if (email != null) {
			student.setEmail(email);
		}
		
	}
}
