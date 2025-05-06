package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="uname",length = 20)
	private String username;
	@Column(name="password", length = 50)
	private String password;
	@Column(name="about")
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	List<Post> posts;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	List<Comment> comments;
	
	
}
