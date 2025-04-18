package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addOrUpdateUser(User user) {
		
		Session session = factory.openSession();
		Transaction tx  =session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		
	}

	@Override
	public List<User> allusers() {
		
		Session session = factory.openSession();
		Transaction tx  =session.beginTransaction();
		
		return session.createQuery("from User").list();
	}

	@Override
	public User userById(int id) {
		
		Session session = factory.openSession();
		Transaction tx  =session.beginTransaction();
		return session.get(User.class, id);
	}

	@Override
	public void deleteUser(int id) {
		
		Session session = factory.openSession();
		Transaction tx  =session.beginTransaction();
		session.delete(session.get(User.class, id));
		tx.commit();
		
	}

}
