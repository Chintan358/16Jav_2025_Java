package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.APIResponse;
import com.example.demo.payload.CommentDto;
import com.example.demo.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@GetMapping("/")
	public ResponseEntity<List<CommentDto>> getMethodName() {
		List<CommentDto> comments = commentService.allComments();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@PostMapping("/user/{uid}/post/{pid}")
	public ResponseEntity<CommentDto> postMethodName(@RequestBody CommentDto comment,@PathVariable("uid") int uid,@PathVariable("pid")int pid  ) {
		//TODO: process POST request
		CommentDto createdComment = commentService.addComment(comment, uid, pid);
		return new ResponseEntity<>(createdComment, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<CommentDto>> commentByUser(@PathVariable("uid")int uid) {
		List<CommentDto> commentsByUser = commentService.commentsByuser(uid);
		return new ResponseEntity<>(commentsByUser, HttpStatus.OK);
	}
	
	@GetMapping("/post/{pid}")
	public ResponseEntity<List<CommentDto>> commentByPost(@PathVariable("pid")int pid) {
		List<CommentDto> commentsByPost = commentService.commentsByPost(pid);
		return new ResponseEntity<>(commentsByPost, HttpStatus.OK);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<APIResponse> deleteComment(@PathVariable("cid")int cid) {
		commentService.deleteComment(cid);
		return new ResponseEntity<>(new APIResponse("Comment Deleted","true"), HttpStatus.OK);
	}
	
	@PutMapping("{cid}/user/{uid}/post/{pid}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto comment,@PathVariable("cid")int cid,@PathVariable("uid")int uid,@PathVariable("pid")int pid) {
		CommentDto updatedComment = commentService.updateComment(comment, cid, uid, pid);
		return new ResponseEntity<>(updatedComment, HttpStatus.CREATED);
	}
}
