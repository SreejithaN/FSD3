package comm.example.dao;

import java.util.List;

import comm.example.model.Customer;
import comm.example.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomer();
	public void deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void updateCustomer(int id ,Customer c);
	public List<Customer> findCustomer(String str);
	public List<Customer> OrderBy(String str);
	public List<Customer> OrderByDesc(String str);
	public List<Customer> sortCustomer(String str);
}