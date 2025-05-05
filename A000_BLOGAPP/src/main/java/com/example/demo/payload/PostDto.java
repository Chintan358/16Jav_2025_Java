package com.example.demo.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	int id;
	
	@NotBlank
	String title;
	@NotBlank
	String content;
	
	String image;
	
	CategoryDto category;
	
	UserDto user;
}
