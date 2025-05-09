package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String role;
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
	List<User> user;
}
