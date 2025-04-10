package com;

import java.util.List;
import java.util.Set;

public class Student {
	
	int id;
	String name;
	String email;
	List<String> subject;
	Set<String> lang;	
	Address address;
	List<Subject> subjects;
	
	public Address getAddress() {
		return address;
	}





	public void setAddress(Address address) {
		this.address = address;
	}





	public Set<String> getLang() {
		return lang;
	}
	
	



	public void setLang(Set<String> lang) {
		this.lang = lang;
	}




	public List<String> getSubject() {
		return subject;
	}




	public void setSubject(List<String> subject) {
		this.subject = subject;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void display()
	{
		System.out.println(id+" "+name+" "+email);
		for(String sub  :subject)
		{
			System.out.println(sub);
		}
		for(String l : lang)
		{
			System.out.println(l);
		}
		address.display();
		for(Subject sub  :subjects)
		{
			sub.display();
		}
	}





	public List<Subject> getSubjects() {
		return subjects;
	}





	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
}
