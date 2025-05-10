package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.UserDto;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	RoleRepo roleRepo;

	@Override
	public List<UserDto> allUser() {
		
		List<User> allusers = userRepo.findAll();
		List<UserDto> dtos = allusers.stream().map(user->this.userTodto(user)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto addUser(UserDto user, int rid) {
		
		Role role = roleRepo.findById(rid).orElseThrow(()-> new ResourceNotFoundException("Role", "Id", rid));
		
		User usertosave = this.dtoToUser(user);
		usertosave.setRole(role);
	
		User u = userRepo.save(usertosave);
		return this.userTodto(u);
	}

	@Override
	public UserDto userById(int id) {
		
		return this.userTodto(userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id)));
	}

	@Override
	public UserDto userUpdate(UserDto user, int id) {
		
		User u =  userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setAbout(user.getAbout());
		return this.userTodto(userRepo.save(u));
	}

	@Override
	public void deletById(int id) {
		
		User u =  userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		userRepo.delete(u);
		
	}
	
	public User dtoToUser(UserDto userdto)
	{
      	User user = mapper.map(userdto, User.class);
//		user.setId(userdto.getId());
//		user.setUsername(userdto.getUsername());
//		user.setPassword(userdto.getPassword());
//		user.setAbout(userdto.getAbout());
		return user;
	}

	
	public UserDto userTodto(User user)
	{
		UserDto dto = mapper.map(user, UserDto.class);
		
//		dto.setId(user.getId());
//		dto.setUsername(user.getUsername());
//		dto.setPassword(user.getPassword());
//		dto.setAbout(user.getAbout());
		return dto;
	}
	

	
}
