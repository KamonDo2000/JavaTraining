package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Seat;
import ultil.HibernateUltil;

public class SetDaoImpl implements SetDao {

	private final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public Seat GetSetByID(int id) {
		Session session = null;

		try {
			session = factory.openSession();
			Seat seat = session.get(Seat.class, id);
			if (seat != null) {
				return seat;
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
	public List<Seat> GetAllSet() {
		List<Seat> seats = null;
		Session session = null;
		try {
			session = factory.openSession();
			seats = session.createQuery("FROM Seat", Seat.class).list();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return seats;
	}

	@Override
	public void UpdateSetByID(int id, Seat seat) {
		Session session = null;
		Transaction trans = null;
		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Seat sea = session.get(Seat.class, id);

			if (sea != null) {

				sea.setSeatColumn(seat.getSeatColumn());
				sea.setSeatRow(seat.getSeatRow());
				sea.setSeatStatus(seat.getSeatStatus());
				sea.setSeatType(seat.getSeatType());
				sea.setCinemaInfo(seat.getCinemaInfo());

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
	public void DeleteSetById(int id) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			Seat seat = session.get(Seat.class, id);
			if (seat != null) {
				session.delete(seat);

			}

			trans.commit();
			System.out.println("delete success");
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
	public void InsertSet(Seat seat) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			session.save(seat);
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
