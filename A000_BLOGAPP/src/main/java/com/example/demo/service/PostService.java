package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Post;

public interface PostService {

	public List<Post> allPost();
	public Post addPost(Post post);
	public Post postById(int id);
	public Post postUpdate(Post post, int id);
	
}
