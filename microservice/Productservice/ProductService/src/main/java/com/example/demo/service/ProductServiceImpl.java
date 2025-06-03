package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.repo.ProductRepo;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Products> allProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Products createProducts(Products products) {
		// TODO Auto-generated method stub
		return productRepo.save(products);
	}

	@Override
	public Products byId(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Products> ProductsByCat(int id) {
	
		return productRepo.findByCatId(id);
	}
	


}
