package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.APIResponse;
import com.example.demo.payload.UserDto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
		
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> viewAllUser()
	{
		List<UserDto> users = userService.allUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/role/{rid}")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto dto, @PathVariable("rid") int rid)
	{
		dto.setPassword(encoder.encode(dto.getPassword()));
		UserDto createUser = userService.addUser(dto,rid);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> userById(@PathVariable("userId") int userId)
	{
		UserDto userDto = userService.userById(userId);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable("userId") int userId)
	{
		userService.deletById(userId);
		APIResponse repResponse = new APIResponse("User Delete successfully","true");
		return new ResponseEntity<APIResponse>(repResponse,HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity updateUser(@RequestBody UserDto dto , @PathVariable("userId") int userId)
	{
		UserDto updatedUser = userService.userUpdate(dto, userId);
		return new ResponseEntity(updatedUser,HttpStatus.OK);
	}
	
}
