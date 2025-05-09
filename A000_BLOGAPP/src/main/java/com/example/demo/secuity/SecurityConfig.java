package com.example.demo.secuity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager detailsManager()
	{
		
		UserDetails adminUser = 
				User.withUsername("admin")
				.password(encoder().encode("admin"))
				.roles("ADMIN").build();
		
		UserDetails publicUser = 
				User.withUsername("user")
				.password(encoder().encode("user"))
				.roles("USER").build();
		
		
		InMemoryUserDetailsManager detailsManager = 
				new InMemoryUserDetailsManager(adminUser,publicUser);
		return detailsManager;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/comments/**")
		.permitAll()
		.requestMatchers("/categories/**")
		.hasRole("ADMIN")
		.requestMatchers("/posts/**")
		.hasRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
}
