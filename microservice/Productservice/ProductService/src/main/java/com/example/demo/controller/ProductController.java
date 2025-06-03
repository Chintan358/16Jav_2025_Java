package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Products;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity createProduct(@RequestBody Products products)
	{
		Products pro = productService.createProducts(products);
		return new ResponseEntity(pro, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity allProducts()
	{
		List<Products> allprod = productService.allProducts();
		return new ResponseEntity(allprod,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity allProducrtbyid(@PathVariable("id") int id)
	{
		Products pro = productService.byId(id);
		return new ResponseEntity(pro,HttpStatus.OK);
	}
	
	
	@GetMapping("/category/{id}")
	public ResponseEntity productsBycategory(@PathVariable("id") int id)
	{
		List<Products> allprod = productService.ProductsByCat(id);
		return new ResponseEntity(allprod,HttpStatus.OK);
	}
	

}
