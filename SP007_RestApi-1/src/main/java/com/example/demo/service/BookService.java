package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Author;
import com.example.demo.model.Book;

public interface BookService {
		
		public List<Book> allbooks();
		public Book bookById(int id);
		public Book addBook(Book book);
		public Book updateBook(Book book, int id);
		public void deleteBook(int id);
		public List<Book> booksByAuthor(int aid);
		public List<Book> booksByPublication(int pid);
		
}
