package com.mycompany.hibernate_using_inheritance_employee;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emplyee_type")
@DiscriminatorValue("Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String eid;
	private Date dob;
	private double salary;

	public Employee() {
	}

	public Employee(String name, String eid, Date dob, double salary) {
		this.name = name;
		this.eid = eid;
		this.dob = dob;
		this.salary = salary;
	}
}
