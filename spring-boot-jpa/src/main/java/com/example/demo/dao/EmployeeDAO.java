package com.example.demo.dao;
import java.util.List;

import com.example.demo.entity.Employee;
public interface EmployeeDAO {
	public List<Employee> getAllEmployee();
	public void  save(Employee employee);
	public Employee update(Employee theEmployee);
}
