package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.payload.UserDto;

public interface UserService {

	public List<UserDto> allUser();
	public UserDto addUser(UserDto user);
	public UserDto userById(int id);
	public UserDto userUpdate(UserDto user, int id);
	public void deletById(int id);
	
}
