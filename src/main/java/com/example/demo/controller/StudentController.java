package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping
	public List<Student> getStudent() {
		return this.studentService.getStudent();
	}
	
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		this.studentService.addStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id) {
		this.studentService.deleteStudent(id);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(@PathVariable("studentId") Long id,
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String email) {
		this.studentService.updateStudent(id, name, email);
	}
}
