package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Movie;
import ultil.HibernateUltil;

public class MovieDAOiml implements movieDAO {

	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public Movie GetMovieByID(String id) {
		Session session = null;
		try {
			session = factory.openSession();
			Movie movie = session.get(Movie.class, id);

			if (movie != null) {
				return movie;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<Movie> GetAllMovie() {
		List<Movie> room = null;
		Session session = null;
		try {
			session = factory.openSession();

			String hql = "FROM Movie";
			room = session.createQuery(hql, Movie.class).list();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return room;
	}

	@Override
	public void InsertMovie(Movie movie) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			session.save(movie);
			trans.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void DeleteMovieById(String id) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Movie seat = session.get(Movie.class, id);
			if (seat != null) {
				session.delete(seat);
				trans.commit();
				System.out.println("delete success");
			}

		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void UpdateMovieByID(String id, Movie mo) {
		Session session = null;
		Transaction trans = null;
		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Movie sea = session.get(Movie.class, id);

			if (sea != null) {

				sea.setDirector(mo.getDirector());
				sea.setActor(mo.getActor());
				sea.setContent(mo.getContent());

				session.update(sea);
				trans.commit();
				System.out.println("Update success");
			}

		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
