package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Employee;
public class EmployeeDAOImpl implements EmployeeDAO {
	private EntityManager entityManager;
	@Autowired
	public void EmplyeeDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee(){
		Query query=entityManager.createQuery("FROM employee",Employee.class);
		return query.getResultList();
		
	}
	@Override
	public void  save(Employee employee) {
		// TODO Auto-generated method stub
		Employee theEmployee=entityManager.merge(employee);
		//employee;
	}
	@Override
	public Employee update(Employee theEmployee) {
		// TODO Auto-generated method stub
		save(theEmployee);
		return theEmployee;
	}
}
