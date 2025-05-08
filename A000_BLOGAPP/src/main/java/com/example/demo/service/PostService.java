package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Post;
import com.example.demo.payload.PostDto;

public interface PostService {

	public List<PostDto> allPost(int pageNumber, int pagesize,String sortBy, String sortType);
	public PostDto addPost(PostDto post,int catid, int uid);
	public PostDto postById(int id);
	public PostDto postUpdate(PostDto post, int id,int catid, int uid);
	public void deletePost(int id);
	public List<PostDto> postsbyCategory(int id);
	public List<PostDto> postsByUsers(int id);
	public List<PostDto> searchPost(String keyword);
	public PostDto addImage(PostDto dto);
}
