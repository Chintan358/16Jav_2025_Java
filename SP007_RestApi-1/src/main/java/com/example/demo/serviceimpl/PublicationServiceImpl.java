package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.PublicationRepo;
import com.example.demo.service.PublicationService;
import com.example.demo.model.Publication;


@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	PublicationRepo publicationRepo;
	
	@Override
	public List<Publication> allPublications() {
		// TODO Auto-generated method stub
		return publicationRepo.findAll();
	}

	@Override
	public Publication Publication(Publication pub) {
		// TODO Auto-generated method stub
		return publicationRepo.save(pub);
	}

	@Override
	public Publication updatePublication(Publication pub, int id) {
		// TODO Auto-generated method stub
		pub.setId(id);
		return publicationRepo.save(pub);
	}

	@Override
	public void deletePublication(int id) {
		// TODO Auto-generated method stub
		publicationRepo.deleteById(id);;
	}

	@Override
	public Publication PublicationById(int id) {
		// TODO Auto-generated method stub
		return publicationRepo.findById(id).orElseThrow();
	}

}
