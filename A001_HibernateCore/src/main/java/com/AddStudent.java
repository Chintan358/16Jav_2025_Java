package com;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	public static void main(String[] args) {
		
		Student st = new Student();
		st.setId(10);
		st.setName("Rohit");
		st.setEmail("rohit@gmail.com");

		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(st);
		tx.commit();
		
		
	}
}
