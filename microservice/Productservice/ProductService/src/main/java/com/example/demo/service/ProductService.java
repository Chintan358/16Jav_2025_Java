package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Products;

public interface ProductService {
	
		List<Products> allProducts();
		Products createProducts(Products products);
		Products byId(int id);
		List<Products> ProductsByCat(int id);
	
}
