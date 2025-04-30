package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.payload.UserDto;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<UserDto> allUser() {
		
		List<User> allusers = userRepo.findAll();
		List<UserDto> dtos = new ArrayList<>();
		for(User user : allusers)
		{
			dtos.add(this.userTodto(user));
		}
		return dtos;
	}

	@Override
	public UserDto addUser(UserDto user) {
		
		User u = userRepo.save(this.dtoToUser(user));
		return this.userTodto(u);
	}

	@Override
	public UserDto userById(int id) {
		
		return this.userTodto(userRepo.findById(id).orElseThrow());
	}

	@Override
	public UserDto userUpdate(UserDto user, int id) {
		user.setId(id);
		return this.userTodto(userRepo.save(this.dtoToUser(user)));
	}

	@Override
	public void deletById(int id) {
		
		userRepo.deleteById(id);
		
	}
	
	public User dtoToUser(UserDto userdto)
	{
		User user = new User();
		user.setId(userdto.getId());
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		return user;
	}

	
	public UserDto userTodto(User user)
	{
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setAbout(user.getAbout());
		return dto;
	}
	

}
