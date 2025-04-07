package org;

import java.awt.datatransfer.Transferable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.AdharCard;
import com.Citizen;
import com.mysql.cj.protocol.ReadAheadInputStream;

public class AddData {
	public static void main(String[] args) {
		
		
		SessionFactory sf = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Citizen.class)
				.addAnnotatedClass(AdharCard.class)
				.buildSessionFactory();
		
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
	
		
		AdharCard ac = new AdharCard();
		ac.setAdharNo("528574859685");
		
		Citizen ct = new Citizen();
		ct.setName("Roshan");
		ct.setEmail("roshan@gmail.com");
		ct.setAdharCard(ac);
		
		
//		session.save(ac);
		session.save(ct);
		
		tx.commit();
		
		
		
	}
}
