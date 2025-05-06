package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	public List<Comment> findByUser(User user);
	public List<Comment> findByPost(Post post);
}
