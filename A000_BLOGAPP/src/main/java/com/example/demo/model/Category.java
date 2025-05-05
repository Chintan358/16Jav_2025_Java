package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title",length = 20)
	private String title;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	List<Post> posts;
	

	
}
