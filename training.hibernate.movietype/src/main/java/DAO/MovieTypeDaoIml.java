package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.MovieType;
import ultil.HibernateUltil;

public class MovieTypeDaoIml implements movieTypeDAO {

	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public List<MovieType> GetMovieTypeByTypeID(int id) {
		Session session = null;
		try {
			session = factory.openSession();

			String hql = "From MovieType M where M.typeMovie like '" + id + "'";
			List<MovieType> movies = session.createQuery(hql, MovieType.class).list();

			if (movies != null) {
				return movies;
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
	public List<MovieType> GetAllMovieType() {
		Session session = null;
		try {
			session = factory.openSession();

			String hql = "From MovieType";
			List<MovieType> movies = session.createQuery(hql, MovieType.class).list();

			if (movies != null) {
				return movies;
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
	public void UpdateMovieTypeByID(int id, MovieType room) {

	}

	@Override
	public void DeleteMovieTypeById(int id) {

	}

	@Override
	public void InsertMovieType(MovieType mvt) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			session.save(mvt);
			trans.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
