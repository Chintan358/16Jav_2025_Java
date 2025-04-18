package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	public void addOrUpdateUser(User user);
	public List<User> allusers();
	public User userById(int id);
	public void deleteUser(int id);
}
