package com.example.demo.payload;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
	private int id;
	private String content;

	private UserDto user;
	
	private PostDto post;
}
