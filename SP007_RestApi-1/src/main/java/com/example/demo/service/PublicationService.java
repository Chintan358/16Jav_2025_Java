package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Publication;

public interface PublicationService {
	
		public List<Publication> allPublications();
		public Publication Publication(Publication pub);
		public Publication updatePublication(Publication pub, int id);
		public void deletePublication(int id);
		public Publication PublicationById(int id);
}
