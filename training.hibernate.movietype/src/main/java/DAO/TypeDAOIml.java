package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Type;
import ultil.HibernateUltil;

public class TypeDAOIml implements typeDAO {
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public Type GetTypeByID(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			Type movie = session.get(Type.class, id);

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
	public List<Type> GetAllType() {
		List<Type> room = null;
		Session session = null;
		try {
			session = factory.openSession();

			String hql = "FROM Type";
			room = session.createQuery(hql, Type.class).list();

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
	public void InsertType(Type room) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			session.save(room);
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
	public void UpdateTypeByID(int id, Type type) {
		Session session = null;
		Transaction trans = null;
		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Type sea = session.get(Type.class, id);

			if (sea != null) {

				sea.setName(type.getName());
				sea.setDescription(type.getDescription());

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

	@Override
	public void DeleteTypeById(int id) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Type seat = session.get(Type.class, id);
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

}
