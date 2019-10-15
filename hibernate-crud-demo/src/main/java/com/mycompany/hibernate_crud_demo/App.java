package com.mycompany.hibernate_crud_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_crud_demo.dao.EmployeeDAO;
import com.mycompany.hibernate_crud_demo.dao.EmployeeDAOImpl;
import com.mycompany.hibernate_crud_demo.model.Employee;
import com.mycompany.hibernate_crud_demo.shared.SharedEmployee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EmployeeDAO dao=new EmployeeDAOImpl();
        try {
			/*
			 * dao.createEmployee(new SharedEmployee("Shane", "Warne",
			 * "shane@luv2code.com")); System.out.println("inserted");
			 */
        	
        	List<SharedEmployee> se=dao.getAllEmployee();
        	for(SharedEmployee see:se)
        	{
        		System.out.println(see);
        	}
        	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}

