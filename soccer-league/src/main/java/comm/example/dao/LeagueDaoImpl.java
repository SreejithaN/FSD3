package comm.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import comm.example.factory.HibernateUtilFactory;
import comm.example.model.League;

public class LeagueDaoImpl implements LeagueDao {

	private Session session = null;
	private SessionFactory factory = null;

	{
		factory = HibernateUtilFactory.getSessionFactory();
	}

	public void createLeague(League league) {
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(league);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}
	public void deleteLeague(League league) {
		// TODO Auto-generated method stub
		try {

			session.beginTransaction();

			int theId = 1;
			League tempInstructor = session.get(League.class, theId);

			System.out.println("Found League: " + tempInstructor);

			if (tempInstructor != null) {

				System.out.println("Deleting: " + tempInstructor);

				session.delete(tempInstructor);
			}

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}


}