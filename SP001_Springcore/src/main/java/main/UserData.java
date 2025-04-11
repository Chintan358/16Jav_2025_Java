package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.User;

public class UserData {
	
	public static void main(String[] args) {
		
		ApplicationContext context =new  ClassPathXmlApplicationContext("applicationContext3.xml");
		
		User user = context.getBean("user",User.class);
		user.display();
		
	}
}
