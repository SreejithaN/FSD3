package comm.example.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.model.League;
/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(League.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();

			int theId = 5;
			League tempInstructor = session.get(League.class, theId);
			//System.out.println("Found League: " + tempInstructor);
			if (tempInstructor != null) {
				//System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();
		//	System.out.println("Done!");
			RequestDispatcher view = request.getRequestDispatcher("add_league.view");
			view.forward(request, response);
	
		} finally {
			factory.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}
}
