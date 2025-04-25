package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.PublicationDto;
import com.example.demo.model.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.PublicationService;

@RestController
@RequestMapping("/books")
public class BookController {
		
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	PublicationService publicationService;
	
	@PostMapping("/{aid}/{pid}")
	public ResponseEntity<BookDto> addBook(@RequestBody Book books, @PathVariable("aid") int aid,@PathVariable("pid") int pid)
	{
		books.setAuthor(authorService.authorById(aid));
		books.setPublication(publicationService.PublicationById(pid));
		
		Book createdBook = bookService.addBook(books);
		BookDto dto = new BookDto();
		dto.setId(createdBook.getId());
		dto.setName(createdBook.getName());
		dto.setPrice(createdBook.getPrice());
		AuthorDto adt = new AuthorDto();
		adt.setId(createdBook.getAuthor().getId());
		adt.setName(createdBook.getAuthor().getName());
		dto.setAuthorDto(adt);
		
		PublicationDto pdt = new PublicationDto();
		pdt.setId(createdBook.getPublication().getId());
		pdt.setName(createdBook.getPublication().getName());
		
		dto.setPublicationDto(pdt);
		
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
}
