package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
		@Autowired
		AuthorService authorService;
		
		@PostMapping
		public ResponseEntity<AuthorDto> addAuthor(@RequestBody Author author)
		{
			Author createdAuthor = authorService.addAuthor(author);
			AuthorDto dtos = new AuthorDto();
			dtos.setId(createdAuthor.getId());
			dtos.setName(createdAuthor.getName());
			return new ResponseEntity<>(dtos,HttpStatus.OK);
		}
		
		@GetMapping
		public ResponseEntity<List<AuthorDto>> viewAuthor()
		{
			List<Author> allAuthors = authorService.allAuthors();
			List<AuthorDto> dtos = new ArrayList<>();
			
			for(Author a : allAuthors)
			{
				AuthorDto dt = new AuthorDto();
				dt.setId(a.getId());
				dt.setName(a.getName());
				
				dtos.add(dt);
			}
			
			return new ResponseEntity<>(dtos,HttpStatus.OK);
		}
		
}
