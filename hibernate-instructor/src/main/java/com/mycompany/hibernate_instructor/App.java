package com.mycompany.hibernate_instructor;

import static java.lang.System.in;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.hibernate_instructor.model.Instructor;
import com.mycompany.hibernate_instructor.model.Instructor_detail;
import com.mycompany.hibernate_instructor.factory.MyHibernateFactory;
import com.mycompany.hibernate_instructor.model.Instructor_detail;





/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	try {
    		SessionFactory sessionFactory = MyHibernateFactory.getMySession();
    		Session session = null;
    		
    		
    		
    		session = sessionFactory.openSession();

    		Instructor_detail id = new Instructor_detail();
    		id.setHobby("Cricket");
    		id.setYoutube_channels("www.youtube.com");
    		
    		Instructor i = new Instructor();    		
    		i.setFirst_name("Sunny");
    		i.setLast_name("Deol");
    		i.setEmail("sunny@i.com");
    		
    		
    		
    		session.getTransaction().begin();
    		session.persist(id);
    		session.persist(i);
  			session.getTransaction().commit();	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		   
    }
}

