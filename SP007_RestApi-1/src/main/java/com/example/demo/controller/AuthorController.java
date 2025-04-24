package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
		@Autowired
		AuthorService authorService;
		
		@PostMapping
		public ResponseEntity<Author> addAuthor(@RequestBody Author author)
		{
			Author createdAuthor = authorService.addAuthor(author);
			return new ResponseEntity<>(createdAuthor,HttpStatus.OK);
		}
		
		@GetMapping
		public ResponseEntity<List<Author>> viewAuthor()
		{
			List<Author> allAuthors = authorService.allAuthors();
			return new ResponseEntity<>(allAuthors,HttpStatus.OK);
		}
		
}
