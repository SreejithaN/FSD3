package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeService.getAllEmployee();
	}
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		// TODO Auto-generated method stub
		 employee.setEmployeeId(0);
		 employeeService.save(employee);
		 return employee;
	}
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		return employeeService.update(theEmployee);
	}
}
