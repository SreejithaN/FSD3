package comm.example;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;

public class Tester {

	public static void main(String[] args) {

		try {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			CustomerDAO customerDAO = context.getBean("customerDao", CustomerDAOImpl.class);

			customerDAO.createCustomer(new Customer("Sourav", "Ganguly", "sourav@luv2code.com"));
			customerDAO.deleteCustomer(5);
			System.out.println("ok!");
			System.out.println("Deleted successfully");
			List<Customer> list=customerDAO.getAllCustomer();
			Iterator<Customer> i=list.iterator();
			while(i.hasNext()) {
				Customer c=i.next();
				System.out.println(c.getFirstName()+" , "+c.getLastName()+","+c.getEmail());
			}
			customerDAO.updateCustomer(new Customer("Shefali", "bs", "sourav@luv2code.com"));
			System.out.println("Updated Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}