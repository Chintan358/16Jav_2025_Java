package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publication;
import com.example.demo.repo.AuthorRepo;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.PublicationRepo;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	PublicationRepo publicationRepo;
	
	@Override
	public List<Book> allbooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Book bookById(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElseThrow();
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book, int id) {
		// TODO Auto-generated method stub
		book.setId(id);
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
	}

	@Override
	public List<Book> booksByAuthor(int aid) {
		
		Author author = authorRepo.findById(aid).orElseThrow();
		return bookRepo.findByAuthor(author);
	}

	@Override
	public List<Book> booksByPublication(int pid) {
		// TODO Auto-generated method stub
		Publication pub = publicationRepo.findById(pid).orElseThrow();
		return bookRepo.findByPublication(pub);
	}

}
