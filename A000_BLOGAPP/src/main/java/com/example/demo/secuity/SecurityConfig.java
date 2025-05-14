package com.example.demo.secuity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

	

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	CustomeAuthenticationEntryPoint authenticationEntryPoint;
	jwtAuthenticationFilter authenticationFilter;
	
	
	
	public SecurityConfig(CustomeAuthenticationEntryPoint authenticationEntryPoint,
			jwtAuthenticationFilter authenticationFilter) {
		super();
		this.authenticationEntryPoint = authenticationEntryPoint;
		this.authenticationFilter = authenticationFilter;
	}

	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsManager detailsManager()
//	{
//		
//		UserDetails adminUser = 
//				User.withUsername("admin")
//				.password(encoder().encode("admin"))
//				.roles("ADMIN").build();
//		
//		UserDetails publicUser = 
//				User.withUsername("user")
//				.password(encoder().encode("user"))
//				.roles("USER").build();
//		
//		
//		InMemoryUserDetailsManager detailsManager = 
//				new InMemoryUserDetailsManager(adminUser,publicUser);
//		return detailsManager;
//	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/login","/refresh-token")
		.permitAll()
		.requestMatchers(HttpMethod.POST,"/users/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET,"/posts/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET,"/categories/**")
		.permitAll()
		.requestMatchers("/users/**")
		.hasAnyRole("USER","ADMIN")
		.requestMatchers("/posts/**")
		.hasRole("USER")
		.requestMatchers("/categories/**")
		.hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling(exception->exception.authenticationEntryPoint(authenticationEntryPoint))
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(authenticationFilter,UsernamePasswordAuthenticationFilter.class);
	
		
		return http.build();
	}
	
}
