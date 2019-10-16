package com.mycompany.hibernate_instructor.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_instructor.model.Instructor;
import com.mycompany.hibernate_instructor.model.Instructor_detail;


public class MyHibernateFactory {
private static SessionFactory factory;
	
	public static SessionFactory getMySession()
	{
		factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).addAnnotatedClass(Instructor_detail.class)
				.buildSessionFactory();
		return factory;
				
	}
}

