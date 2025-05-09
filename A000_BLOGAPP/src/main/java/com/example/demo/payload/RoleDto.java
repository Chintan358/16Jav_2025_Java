package com.example.demo.payload;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
	
	int id;
	String role;
	
	List<UserDto> user;
}
