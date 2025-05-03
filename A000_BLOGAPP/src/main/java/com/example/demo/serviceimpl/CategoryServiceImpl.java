package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.payload.CategoryDto;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<CategoryDto> allCategories() {
		
		List<Category> allCategories = categoryRepo.findAll();
		List<CategoryDto> categoryDtos = 
				allCategories.stream().map(cat->mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		
		Category createdCategory =  categoryRepo.save(mapper.map(categoryDto, Category.class));
		return mapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto categorybyId(int id) {
		
		Category category =  categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", id));
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		
		Category category =  categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", id));
		category.setTitle(categoryDto.getTitle());
		Category updatedCategory = categoryRepo.save(category);
		
		return mapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Category category =  categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Id", id));
		categoryRepo.delete(category);
	}

}
