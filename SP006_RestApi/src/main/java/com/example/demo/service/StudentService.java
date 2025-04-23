package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
		public List<Student> allStudents();
		public Student addStduent(Student st);
		public Student StudentById(int id);
		public void delteStudent(int id);
		public Student UpdateStudent(Student st, int id);
}
