package comm.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;


@WebServlet("/add.view")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SessionFactory factory = null;
	private Session session;

	{}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	
		try {
		session = factory.openSession();
		session.getTransaction().begin();
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String email=request.getParameter("email");
		Customer customer = new Customer(firstname, lastname, email);
		session.persist(customer);
		session.getTransaction().commit();
		RequestDispatcher view = request.getRequestDispatcher("list.do");
		view.forward(request, response);
		}catch(Exception e) {
			session.close();
			factory.close();
		}
	}}

