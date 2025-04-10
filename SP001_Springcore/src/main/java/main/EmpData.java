package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Employee;

public class EmpData {
	public static void main(String[] args) {
		
		
		ApplicationContext context =new  ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Employee e  =context.getBean("emp",Employee.class);
		e.display();
		
		
	}
}
