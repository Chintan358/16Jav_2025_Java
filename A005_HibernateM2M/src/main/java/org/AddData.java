package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Subject;
import com.Teacher;

public class AddData {
	public static void main(String[] args) {
		
		SessionFactory sf = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
	
		
		Subject s1 = new Subject();
		s1.setSname("Android");
	
		
		Teacher t = new Teacher();
		t.setTname("Drashti");
		t.addSubject(s1);
		

		Teacher t1 = new Teacher();
		t1.setTname("Rohit");
		t1.addSubject(s1);
		
		
		session.save(t);
		session.save(t1);
		session.save(s1);
		
		
		tx.commit();
		
		
	}
}
