package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
		
		public List<User> allusers();
		public User UserById(int id);
		public void addOrUpdateUser(User user);
		public void deleteUser(int id);
}
