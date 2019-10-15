package com.mycompany.hibernate_crud_demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="customer")
public class Customer {
private int customerId;
private String customerName;
@OneToOne(cascade = CascadeType.ALL) 
private Address customerAddress;
}
