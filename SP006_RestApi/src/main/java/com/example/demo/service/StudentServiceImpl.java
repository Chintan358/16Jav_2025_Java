package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	
	@Override
	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student addStduent(Student st) {
		// TODO Auto-generated method stub
		return repo.save(st);
	}

	@Override
	public Student StudentById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public void delteStudent(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Student UpdateStudent(Student st, int id) {
		// TODO Auto-generated method stub
		st.setId(id);
		return repo.save(st);
	}
	
}
