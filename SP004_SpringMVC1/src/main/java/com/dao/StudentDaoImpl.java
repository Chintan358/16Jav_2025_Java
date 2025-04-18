package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Student;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Student> allStudents() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		return session.createQuery("from Student").list();
	}

	@Override
	public Student studentById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		return session.get(Student.class, id);
	}

	@Override
	public int addOrUpdateStudent(Student st) {
		
		int i=0;
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(st);
			tx.commit();
			i=1;
		} catch (Exception e) {
			// TODO: handle exception
			i=0;
		}
		return i;
	}

	@Override
	public int deleteStudent(int id) {
		int i=0;
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(session.get(Student.class, id));
			tx.commit();
			i=1;
		} catch (Exception e) {
			// TODO: handle exception
			i=0;
		}
		return i;
	}

}
