package com.mycompany.hibernate_using_inheritance_account;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("CurrentAccount")
public class CurrentAccount extends Account {
	private double CurrentBalance;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String name, String number, double bal, double currentbalance) {
		super(name, number, bal);
		CurrentBalance=currentbalance;
	}
}
