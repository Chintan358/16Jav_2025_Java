package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Author;

public interface AuthorService {
	
		public List<Author> allAuthors();
		public Author addAuthor(Author author);
		public Author updateAuthor(Author author, int id);
		public void deleteAuthor(int id);
		public Author authorById(int id);
}
