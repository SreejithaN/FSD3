package com.mycompany.hibernate_using_inheritance_employee;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeTest {
	public static void main(String[] args) {
		try {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Manager.class)
					.addAnnotatedClass(Supervisor.class).buildSessionFactory();
			Session session = factory.openSession();
			Employee em = new Employee("Grace", "R001", new Date(), 99999.99);
			Manager man = new Manager("Mary", "M001", new Date(), 200000.98,
					"Widescreen");
			Supervisor sup = new Supervisor("Joy", "J001", new Date(), 300000.87, "Spanish", 4);
		session.getTransaction().begin();
			session.save(em);
			session.save(man);
			session.save(sup);
			session.getTransaction().commit();
			System.out.println("ok..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

