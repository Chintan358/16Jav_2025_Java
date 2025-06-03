package com;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Demo
{
	int id;
	String name;
	
	
	
	public Demo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		Demo d = (Demo) obj;
		if(this.id==d.id)
		{
			b  =true;
		}
		else
		{
			b  =false;
		}
		
		return b;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	
	public void display()
	{
		System.out.println(id+" "+name);
	}
}

public class Test {
	public static void main(String[] args) {
		
		Set<Demo> set = new HashSet<>();
		set.add(new Demo(10,"Test"));
		set.add(new Demo(10,"Test"));
		
		for(Demo d : set)
		{
			d.display();
		}
		
		
	}
}
