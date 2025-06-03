package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public List<Category> allCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category byId(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).orElseThrow();
	}

}
