package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.model.Student;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentDao dao;
	
	@Override
	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		return dao.allStudents();
	}

	@Override
	public Student studentById(int id) {
		// TODO Auto-generated method stub
		return dao.studentById(id);
	}

	@Override
	public int addOrUpdateStudent(Student st) {
		// TODO Auto-generated method stub
		return dao.addOrUpdateStudent(st);
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(id);
	}

}
