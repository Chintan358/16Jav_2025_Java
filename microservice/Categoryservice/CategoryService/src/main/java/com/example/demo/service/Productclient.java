package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Products;

@FeignClient(url = "http://localhost:8082",value = "product-client")
public interface Productclient {

	@GetMapping("/products/category/{id}")
	public List<Products> ProductsByCat(@PathVariable("id") int id);
	
}
