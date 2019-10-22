package comm.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;


@WebServlet("/order.do")
public class OrderByAsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new CustomerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Customer> list=dao.OrderBy(request.getParameter("firstName"));
		if(list.isEmpty())
		{
			RequestDispatcher view=request.getRequestDispatcher("list.do");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("customers", list);
			RequestDispatcher view=request.getRequestDispatcher("ascending.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

}
