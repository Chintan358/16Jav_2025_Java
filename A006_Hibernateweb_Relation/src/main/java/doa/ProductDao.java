package doa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;


public class ProductDao {
	
	SessionFactory sf=null;
	public ProductDao() {
		sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();	
	}
	
	
	public List<Category> getCategories()
	{
		Session s = sf.openSession();
		Transaction tx  =s.beginTransaction();
		return s.createQuery("from Category").list();
	}
	
	public List<Product> getProductss()
	{
		Session s = sf.openSession();
		Transaction tx  =s.beginTransaction();
		return s.createQuery("from Product").list();
	}


	public Category getCategory(int cid) {
		
		Session s = sf.openSession();
		Transaction tx  =s.beginTransaction();
		return s.load(Category.class, cid);
	}


	public int addProduct(Product p) {
		
		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx  =s.beginTransaction();
			s.save(p);
			tx.commit();
			i = 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			i = 0;
		}
		
		return i;
	}
	
	
	
	
	
}
