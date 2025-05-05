package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payload.PostDto;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.PostService;

@Service
public class PostServieImpl implements PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<PostDto> allPost() {
		// TODO Auto-generated method stub
		List<Post> all = postRepo.findAll();
		
		List<PostDto> collect = all.stream().map(e->mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect ;
	}

	@Override
	public PostDto addPost(PostDto postdto, int catid, int uid) {
		
		Category cat = categoryRepo.findById(catid)
						.orElseThrow(()->new ResourceNotFoundException("Category","Id",catid));
		
		
		User u = userRepo.findById(uid)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",uid));

		
		Post post = mapper.map(postdto, Post.class);
		post.setCategory(cat);
		post.setUser(u);
		post.setImage("test.png");
		
		Post createdPost =  postRepo.save(post);
		
		return mapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto postById(int id) {
		
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		
		return mapper.map(post, PostDto.class);
	}

	@Override
	public PostDto postUpdate(PostDto postdto, int id, int catid, int uid) {
		
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		
		Category cat = categoryRepo.findById(catid)
				.orElseThrow(()->new ResourceNotFoundException("Category","Id",catid));


		User u = userRepo.findById(uid)
		.orElseThrow(()->new ResourceNotFoundException("User","Id",uid));
		post.setTitle(postdto.getTitle());
		post.setContent(postdto.getContent());
		post.setCategory(cat);
		post.setUser(u);
		post.setImage("test.png");
		
		Post updatedPost =  postRepo.save(post);
		
		return mapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		
		postRepo.delete(post);
	}

}
