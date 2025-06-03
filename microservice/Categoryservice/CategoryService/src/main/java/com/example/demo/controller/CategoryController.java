package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.Productclient;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	
	Productclient productclient;
	
	
	public CategoryController(Productclient productclient) {
		super();
		this.productclient = productclient;
	}

	@PostMapping("/")
	public ResponseEntity createCategory(@RequestBody Category category)
	{
		Category cat = categoryService.createCategory(category);
		
		
		
		return new ResponseEntity(cat, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity allCategory()
	{
		List<Category> allcat = categoryService.allCategory();
		
		allcat.stream().map(cat->{
			cat.setProducts(productclient.ProductsByCat(cat.getId()));
			return cat;
		}).collect(Collectors.toList());
		
		return new ResponseEntity(allcat,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity allCategorybyid(@PathVariable("id") int id)
	{
		Category cat = categoryService.byId(id);
		return new ResponseEntity(cat,HttpStatus.OK);
	}
	
	

}
