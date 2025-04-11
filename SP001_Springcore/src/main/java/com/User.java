package com;

public class User {
	
	int id;
	String name;
	String email;
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public User(int id)
	{
		this.id = id;
	}
	
	public void display()
	{
		System.out.println(id+" "+name+" "+email);
	}
}
