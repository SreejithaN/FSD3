package com.mycompany.hibernate_crud_demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@Column(name="address_id")
private int addressId;
private String addressLine1;
private String addressLine2;
private String zipCode;
private String phoneNumber;
}