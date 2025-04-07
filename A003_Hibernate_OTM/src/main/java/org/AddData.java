package org;


import java.awt.datatransfer.Transferable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;

public class AddData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
//		Category c1 = new Category();
//		c1.setCname("sports");
		
		Category c1 = session.get(Category.class, 1);
		
		
		Product p1 = new Product();
		p1.setPname("Shirt");
		p1.setCategory(c1);
		
		Product p2 = new Product();
		p2.setPname("Pant");
		p2.setCategory(c1);
		
		
		session.save(c1);
		session.save(p1);
		session.save(p2);
		
		
		
		
		tx.commit();
		
		
		
	}
}
