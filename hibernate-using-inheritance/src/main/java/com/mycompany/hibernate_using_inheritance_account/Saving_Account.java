package com.mycompany.hibernate_using_inheritance_account;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Saving_Account")
public class Saving_Account extends Account {
	private double Withdrawal;
	private double Deposit;

	public Saving_Account() {
	}

	public Saving_Account(String name, String number, double bal,double withdrawal, double deposit) {
		super(name, number, bal);
		this.Withdrawal=withdrawal;
		this.Deposit=deposit;
	}


}