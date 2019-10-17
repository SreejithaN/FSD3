package com.mycompany.hibernate_using_inheritance_employee;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Manager")
public class Manager extends Employee {
	private String newskills;

	public Manager() {
		super();
	}

	public Manager(String name, String eid, Date dob, double salary, String skills) {
		super(name, eid, dob, salary);
		newskills = skills;
	}
}
