package org.customer.app.factory;

import java.util.List;

import org.customer.app.model.Customer;

public interface CustomerFactory {
	
	public Customer createCustomer(int id,String name,String email);
	public List<Customer> getAllCustomer();
	public void findById(String name1);
	public void deleteCust(int id);
	public void update(int id);

}
