package com;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ViewStudent {
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
		
//		Student std =  s.load(Student.class, 1);
//		Student std =  s.get(Student.class, 1);
		
		List<Student> students = s.createQuery("from Student s where s.id=11").list();
		
		for(Student std :students)
		{
		System.out.println(std.getId()+" "+std.getName()+" "+std.getEmail());
		}
		tx.commit();
		
		
	}
}
