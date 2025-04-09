package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Student;

public class StudentData {
	public static void main(String[] args) {
		
		
		ApplicationContext context =new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student st = context.getBean("std",Student.class);
		
		st.display();
		
		
	}
}
