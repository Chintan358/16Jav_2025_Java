package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface CategoryService {
	
		List<Category> allCategory();
		Category createCategory(Category category);
		Category byId(int id);
	
}
