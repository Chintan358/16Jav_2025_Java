package doa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDao {
	
	SessionFactory sf=null;
	public UserDao() {
		sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();	
	}
	
	
	
	public int addorUpdateUser(User u)
	{
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(u);
			tx.commit();
			i=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public List<User> allUsers()
	{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		return session.createQuery("from User").list();
	}



	public int deleteUser(int uid) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			User u = session.get(User.class, uid);
			session.delete(u);
			tx.commit();
			i=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}



	public User userById(int uid) {
		
		
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			return session.get(User.class, uid);
			
	
		
	}
	
	
}
