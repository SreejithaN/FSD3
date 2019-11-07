package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDAO employeeDAO;
	
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		// TODO Auto-generated constructor stub
		this.employeeDAO=employeeDAO;
	}


	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployee();
	}


	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDAO.save(employee);
	}


	@Override
	public Employee update(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.update(theEmployee);
	}

}
