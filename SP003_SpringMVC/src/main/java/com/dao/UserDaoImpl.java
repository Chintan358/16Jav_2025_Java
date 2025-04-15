package com.dao;

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

}
