package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.CategoryDto;

public interface CategoryService {
		
	public List<CategoryDto> allCategories();
	public CategoryDto addCategory(CategoryDto categoryDto);
	public CategoryDto categorybyId(int id);
	public CategoryDto updateCategory(CategoryDto categoryDto, int id);
	public void deleteCategory(int id);
	
}
