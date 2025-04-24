package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repo.AuthorRepo;
import com.example.demo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepo authorRepo;
	
	@Override
	public List<Author> allAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}

	@Override
	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepo.save(author);
	}

	@Override
	public Author updateAuthor(Author author, int id) {
		// TODO Auto-generated method stub
		author.setId(id);
		return authorRepo.save(author);
	}

	@Override
	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		authorRepo.deleteById(id);
	}

	@Override
	public Author authorById(int id) {
		// TODO Auto-generated method stub
		return authorRepo.findById(id).orElseThrow();
	}

}
