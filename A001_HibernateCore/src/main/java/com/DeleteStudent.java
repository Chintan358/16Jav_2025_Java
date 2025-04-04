package com;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
	public static void main(String[] args) {
		
		Student st = new Student();
		st.setId(12);
		st.setName("Roshan-update");
		st.setEmail("roshan@gmail.com");

		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Student std =  s.load(Student.class, 10);

		s.delete(std);
	
		tx.commit();
		
		
	}
}
