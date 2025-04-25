package com.example.demo.dto;

public class BookDto {
	
	int id;
	String name;
	double price;
	AuthorDto authorDto;
	PublicationDto publicationDto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AuthorDto getAuthorDto() {
		return authorDto;
	}
	public void setAuthorDto(AuthorDto authorDto) {
		this.authorDto = authorDto;
	}
	public PublicationDto getPublicationDto() {
		return publicationDto;
	}
	public void setPublicationDto(PublicationDto publicationDto) {
		this.publicationDto = publicationDto;
	}
	
	
	
}
