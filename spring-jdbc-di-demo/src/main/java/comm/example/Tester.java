package comm.example;

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
			System.out.println("ok!");
			List<Customer> list=customerDAO.getAllCustomer();
			for(Customer c:list) {
				System.out.println(c.getFirstName()+" "+c.getLastName()+" "+c.getEmail());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}