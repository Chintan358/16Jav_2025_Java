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

import com.example.demo.dto.PublicationDto;
import com.example.demo.model.Publication;
import com.example.demo.service.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {
	
	@Autowired
	PublicationService publicationService;
	
	@PostMapping("/")
	public ResponseEntity<PublicationDto> addPublication(@RequestBody Publication pub)
	{
		Publication createdPub = publicationService.Publication(pub);
		PublicationDto dtos = new PublicationDto();
		dtos.setId(createdPub.getId());
		dtos.setName(createdPub.getName());
		return new ResponseEntity<>(dtos,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<PublicationDto>> viewPublication()
	{
		List<Publication> allPublications = publicationService.allPublications();
		List<PublicationDto> dtos = new ArrayList<>();
		
		for(Publication pub : allPublications)
		{
			PublicationDto dto = new PublicationDto();
			dto.setId(pub.getId());
			dto.setName(pub.getName());
			
			dtos.add(dto);
		}
				
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
}
