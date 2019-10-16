package com.mycompany.hibernate_instructor.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="instructorDetails")
public class Instructor_detail {
	
	@Id
	@Column(name = "instructorDetailsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructor_details_id;
	
	@Column(name="youtube_channels")
	private String youtube_channels;
	
	@Column(name="hobby")
	private String hobby;
	
	

}

