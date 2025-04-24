package com.example.demo.repo;


import java.beans.JavaBean;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publication;

public interface BookRepo extends JpaRepository<Book, Integer> {

	public List<Book> findByAuthor(Author author);
	public List<Book> findByPublication(Publication publication);
}
