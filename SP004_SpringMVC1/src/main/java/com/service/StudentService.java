package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	
	public List<Student> allStudents();
	public Student studentById(int id);
	public int addOrUpdateStudent(Student st);
	public int deleteStudent(int id);
}
