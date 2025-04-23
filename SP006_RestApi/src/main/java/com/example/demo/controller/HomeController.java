package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class HomeController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> viewStudents()
	{
		List<Student> students = studentService.allStudents();
		return students;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student st)
	{
		Student createStudent = studentService.addStduent(st);
		return createStudent;
	}
	
}
