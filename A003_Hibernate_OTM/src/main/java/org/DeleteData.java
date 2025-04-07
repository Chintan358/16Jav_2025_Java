package org;


import java.awt.datatransfer.Transferable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;

public class DeleteData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
//		Product p = session.get(Product.class, 6);
//		session.delete(p);
		
		
		Category c = session.get(Category.class, 1);
		session.delete(c);
		
	
		
		
		
		
		tx.commit();
		
		
		
	}
}
