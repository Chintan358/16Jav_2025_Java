package com.example.demo.payload;

public record JWTResponse(
		String accessToken,
		String refreshToken,
		UserDto dto
		) 
{

}
