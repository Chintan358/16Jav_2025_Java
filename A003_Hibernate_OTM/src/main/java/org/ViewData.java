package org;


import java.awt.datatransfer.Transferable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Category;
import com.Product;

public class ViewData {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
;
		
		//Category c1 = session.get(Category.class, 1);
		
		List<Category> cat = session.createQuery("from Category").list();
		
		for(Category c  :cat)
		{
			System.out.println(c.getId()+" "+c.getCname());
			System.out.println("************");
			for(Product p : c.getProducts())
			{
				System.out.println(p.getId()+" "+p.getPname());
			}
		}
		 
	
		
		
	
		
		
		
		
		tx.commit();
		
		
		
	}
}
