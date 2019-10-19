package comm.example.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import comm.example.model.League;
import comm.example.factory.HibernateUtilFactory;

public class ListLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private List<League> list=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		SessionFactory factory = HibernateUtilFactory.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<League> leagues = (List<League>) session.createQuery("from League").list();
		
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Season</td><td>Title</td><td>Year</td></tr>");
		
		for(League l:leagues)
		{
			out.println("<tr><td>"+l.getSeason()+"</td><td>"+l.getTitle()+"</td><td>"+l.getYear()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
	}

	
}