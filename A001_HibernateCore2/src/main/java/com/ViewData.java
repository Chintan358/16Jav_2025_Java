package com;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ViewData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Emp.class)
				.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		//List<Emp> emps = session.createQuery("from Emp").list();
		
		//List<Emp> result  = session.createCriteria(Emp.class).list();
		
//		
//		List<Emp> emps = session.createQuery("from Emp e where e.dept='IT'").list();
//		for(Emp e : emps)
//		{
//			System.out.println(e);
//		}
		
		
		Query qry = session.createQuery("from Emp e where e.dept=:it");
		qry.setParameter("it", "IT");
		List<Emp> emps = qry.list();
		for(Emp e : emps)
		{
			System.out.println(e);
		}
		
	}
}
