package com.edu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edu.Student;

public class HQLTest {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
		Student st = new Student();
		st.setStudentName("NIT-U");
		session.save(st);
		session.flush();
		transaction.commit();
		System.out.println("Test 1");
		
		}catch(HibernateException e){
			System.err.println("Hibernate Exception "+e.getClass().getName()+ "----------" + e.getMessage());
		//transaction.rollback();
		}
		
	}

}
