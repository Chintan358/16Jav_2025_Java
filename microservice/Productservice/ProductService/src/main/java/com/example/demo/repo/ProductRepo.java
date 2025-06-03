package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

	List<Products> findByCatId(int id);
}
