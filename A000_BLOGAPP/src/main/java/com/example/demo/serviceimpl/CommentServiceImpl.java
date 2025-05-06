package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payload.CommentDto;
import com.example.demo.repo.CommentRepo;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	ModelMapper mapper;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PostRepo postRepo;
	@Override
	public List<CommentDto> allComments() {
		// TODO Auto-generated method stub
		List<Comment> allcomments = commentRepo.findAll();
		List<CommentDto> dtos = allcomments.stream().map(comment->mapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CommentDto addComment(CommentDto comment, int uid, int pid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "id", uid));
		Post post = postRepo.findById(pid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", pid));
		Comment comm = mapper.map(comment, Comment.class);
		comm.setUser(user);
		comm.setPost(post);
		Comment createdComment=commentRepo.save(comm);
		return mapper.map(createdComment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto comment, int id, int uid, int pid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "id", uid));
		Post post = postRepo.findById(pid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", pid));
		Comment comm = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		comm.setContent(comment.getContent());
		comm.setUser(user);
		comm.setPost(post);
		Comment createdComment=commentRepo.save(comm);
		return mapper.map(createdComment, CommentDto.class);
		
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		Comment comm = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		commentRepo.delete(comm);
	}

	@Override
	public CommentDto commentbyid(int id) {
		// TODO Auto-generated method stub
		Comment comm = commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment", "id", id));
		
		return mapper.map(comm, CommentDto.class);
	}

	@Override
	public List<CommentDto> commentsByuser(int uid) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "id", uid));
		List<Comment> byUser = commentRepo.findByUser(user);
		List<CommentDto> dtos = byUser.stream().map(dto->mapper.map(dto, CommentDto.class)).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public List<CommentDto> commentsByPost(int pid) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(pid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", pid));
		List<Comment> byPost = commentRepo.findByPost(post);
		List<CommentDto> dtos = byPost.stream().map(dto->mapper.map(dto, CommentDto.class)).collect(Collectors.toList());
		
		return dtos;
	}

}
