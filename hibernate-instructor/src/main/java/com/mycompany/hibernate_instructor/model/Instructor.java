package com.mycompany.hibernate_instructor.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Instructor_detail instructorDetailsId;
	

}

