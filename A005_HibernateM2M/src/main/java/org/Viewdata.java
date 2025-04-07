package org;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Subject;
import com.Teacher;

public class Viewdata {
	public static void main(String[] args) {
		
		SessionFactory sf = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		List<Subject> subjects = session.createQuery("from Subject").list();
		
		for(Subject s : subjects)
		{
			System.out.println(s.getId()+" "+s.getSname());
			System.out.println("********************");
			for(Teacher t : s.getTeachers())
			{
				System.out.println(t.getId()+" "+t.getTname());
			}
			System.out.println("**********************");
		}
		
		
		
	
		
	}
}
