package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.CommentDto;

public interface CommentService {
	
	public List<CommentDto> allComments();
	public CommentDto addComment(CommentDto comment,int uid,int pid);
	public CommentDto updateComment(CommentDto comment,int id,int uid,int pid);
	public void deleteComment(int id);
	public CommentDto commentbyid(int id);
	public List<CommentDto> commentsByuser(int uid);
	public List<CommentDto> commentsByPost(int pid);
}
