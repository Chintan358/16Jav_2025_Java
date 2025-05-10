package com.example.demo.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
		
	
	private int id;
	
	@NotBlank(message = "Username is Required")
	private String username;
	
	@NotBlank
	@Size(min = 5, max = 15, message = "password length should be between 5 to 15 ")
	private String password;
	
	@NotBlank
	private String about;
	
	RoleDto role;
	
}
