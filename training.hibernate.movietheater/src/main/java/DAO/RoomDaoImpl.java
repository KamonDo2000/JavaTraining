package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.CinemaRoom;
import ultil.HibernateUltil;

public class RoomDaoImpl implements RoomDao {
	private final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public CinemaRoom GetRoomByID(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			CinemaRoom room = session.get(CinemaRoom.class, id);
			if (room != null) {
				return room;
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
	public List<CinemaRoom> GetAllRoom() {
		List<CinemaRoom> room = null;
		Session session = null;
		try {
			session = factory.openSession();
			room = session.createQuery("FROM CinemaRoom", CinemaRoom.class).list();

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
	public void UpdateRoomByID(int id, CinemaRoom room) {
		Session session = null;
		Transaction trans = null;
		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			CinemaRoom sea = session.get(CinemaRoom.class, id);

			if (sea != null) {

				sea.setCinemaRoomName(room.getCinemaRoomName());
				sea.setSeatQuantity(room.getSeatQuantity());

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
	public void DeleteRoomById(int id) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			CinemaRoom room = session.get(CinemaRoom.class, id);
			if (room != null) {
				session.delete(room);
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
	public void InsertRoom(CinemaRoom room) {
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

}
