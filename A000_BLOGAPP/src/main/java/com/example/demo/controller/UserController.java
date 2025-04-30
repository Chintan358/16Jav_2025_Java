package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
		
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> viewAllUser()
	{
		List<UserDto> users = userService.allUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto)
	{
		UserDto createUser = userService.addUser(dto);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> userById(@PathVariable("userId") int userId)
	{
		UserDto userDto = userService.userById(userId);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
	{
		userService.deletById(userId);
		return ResponseEntity.ok("User Deleted");
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity updateUser(@RequestBody UserDto dto , @PathVariable("userId") int userId)
	{
		UserDto updatedUser = userService.userUpdate(dto, userId);
		return new ResponseEntity(updatedUser,HttpStatus.OK);
	}
	
}
