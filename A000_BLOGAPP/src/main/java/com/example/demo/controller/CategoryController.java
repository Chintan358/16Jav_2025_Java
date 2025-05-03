package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.APIResponse;
import com.example.demo.payload.CategoryDto;
import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;
import lombok.val;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createdCategory =  categoryService.addCategory(categoryDto);
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> viewCategories()
	{
		List<CategoryDto> allcategories = categoryService.allCategories();
		return new ResponseEntity<>(allcategories,HttpStatus.OK);
	}
	
	@GetMapping("/{catid}")
	public ResponseEntity<CategoryDto> CategoryByid(@PathVariable("catid") int catid)
	{
		CategoryDto dto = categoryService.categorybyId(catid);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PutMapping("/{catid}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("catid") int catid)
	{
		CategoryDto updatedCategory =  categoryService.updateCategory(categoryDto, catid);
		return new ResponseEntity<>(updatedCategory,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/{catid}")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable("catid") int catid)
	{
		categoryService.deleteCategory(catid);
		return new ResponseEntity<>(new APIResponse("User Deleted","true"),HttpStatus.OK );
	}
}
