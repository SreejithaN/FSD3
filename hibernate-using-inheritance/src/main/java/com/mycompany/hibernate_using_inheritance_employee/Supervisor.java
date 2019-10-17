package com.mycompany.hibernate_using_inheritance_employee;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Supervisor")
public class Supervisor extends Employee {
	private String languages;
	private int region;

	public Supervisor() {
	}

	public Supervisor(String name, String eid, Date dob, double salary, String language, int region) {
		super(name, eid, dob, salary);
		languages = language;
		this.region = region;
	}


}
