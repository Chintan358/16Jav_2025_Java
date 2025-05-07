package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByCategory(Category cat);
	public List<Post> findByUser(User user);
	public List<Post> findByTitleContaining(String keyword);
}
