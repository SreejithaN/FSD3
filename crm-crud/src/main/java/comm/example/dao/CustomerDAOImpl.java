package comm.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private SessionFactory factory = null;
	private Session session;

	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}
	@Override
	public void deleteCustomer(Customer customer) {
		session = factory.openSession();
		session.getTransaction().begin();
		session.remove(customer);
		session.getTransaction().commit();
		
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Customer c=session.get(Customer.class, id);
		return c;
	}
	@Override
	public void updateCustomer(int id, Customer c) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Customer customer = session.get(Customer.class, id);
		customer.setFirstName(c.getFirstName());
		customer.setLastName(c.getLastName());
		customer.setEmail(c.getEmail());
		session.merge(customer);
		session.getTransaction().commit();

	}

	@Override
	public List<Customer> findCustomer(String str) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer WHERE firstName like concat('%',:customerName,'%')");
        query.setParameter("customerName", str);
        session.getTransaction().commit();
		return query.getResultList();
	}
	@Override
	public List<Customer> OrderBy(String str) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer c ORDER BY c.firstName ASC");
		session.getTransaction().commit();
		return query.getResultList();
	}
	@Override
	public List<Customer> OrderByDesc(String str) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer c ORDER BY c.firstName DESC");
		session.getTransaction().commit();
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> sortCustomer(String str) {
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = null;
		if (str.equals("AscendingFirstName")) {
			query = session.createQuery("FROM Customer order by firstName ASC");
		}
		if (str.equals("AscendingLastName")) {
			query = session.createQuery("FROM Customer order by lastName ASC");
		}
		if (str.equals("AscendingEmail")) {
			query = session.createQuery("FROM Customer order by email ASC");
		}
		if (str.equals("DescendingFirstName")) {
			query = session.createQuery("FROM Customer order by firstName DESC");
		}
		if (str.equals("DescendingLastName")) {
			query = session.createQuery("FROM Customer order by lastName DESC");
		}
		if (str.equals("DescendingEmail")) {
			query = session.createQuery("FROM Customer order by email DESC");
		}
		session.getTransaction().commit();
		return query.getResultList();
	}

}

