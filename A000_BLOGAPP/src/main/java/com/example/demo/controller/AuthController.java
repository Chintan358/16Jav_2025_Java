package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.payload.JWTResponse;
import com.example.demo.payload.RefreshTokenRequest;
import com.example.demo.payload.UserDto;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import io.jsonwebtoken.Jwts;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	@Autowired
	UserRepo repo;
	@Autowired
	ModelMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<?> authLogin(@RequestBody UserDto dto){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
		String accessToken = jwtService.generateToken(dto.getUsername(), true);
		String refreshToken = jwtService.generateToken(dto.getUsername(), false);
		
		User user = repo.findByUsername(dto.getUsername());
		UserDto userDto = mapper.map(user, UserDto.class);
		return new ResponseEntity(new JWTResponse(accessToken, refreshToken, userDto),HttpStatus.OK);
		
	}
	
	@PostMapping("/refresh-token")
	public ResponseEntity<?> getrefreshToken(@RequestBody RefreshTokenRequest request)
	{
		if(jwtService.validateToken(request.refreshToken()))
		{
			String usernameFromToken = jwtService.getUsernamefromToken(request.refreshToken());
			String accessToken = jwtService.generateToken(usernameFromToken, true);
			String refreshToken = jwtService.generateToken(usernameFromToken, false);
			
			User user = repo.findByUsername(usernameFromToken);
			UserDto userDto = mapper.map(user, UserDto.class);
			return new ResponseEntity(new JWTResponse(accessToken, refreshToken, userDto),HttpStatus.OK);

		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");

	}
}
