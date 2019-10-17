package com.mycompany.hibernate_using_inheritance_account;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AccountTest {
	public static void main(String[] args) {
		try {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Account.class)
					.addAnnotatedClass(CurrentAccount.class)
					.addAnnotatedClass(Saving_Account.class).buildSessionFactory();
			Session session = factory.openSession();
			Account em = new Account("Grace", "123456789", 99999.99);
			CurrentAccount man = new CurrentAccount("Grace", "123456789", 99999.99,99999.99);
			Saving_Account sup = new Saving_Account("Grace", "123456789", 99999.99,50000.0,0.0);
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
