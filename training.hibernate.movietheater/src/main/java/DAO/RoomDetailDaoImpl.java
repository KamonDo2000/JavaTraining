package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.CinemaRoomDetail;
import ultil.HibernateUltil;

public class RoomDetailDaoImpl implements RoomDetailDao {
	private final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public CinemaRoomDetail GetRoomDetailByID(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			CinemaRoomDetail room = session.get(CinemaRoomDetail.class, id);
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
	public List<CinemaRoomDetail> GetAllRoomDetail() {
		List<CinemaRoomDetail> room = null;
		Session session = null;
		try {
			session = factory.openSession();
			room = session.createQuery("FROM CinemaRoomDetail", CinemaRoomDetail.class).list();

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
	public void UpdateRoomDetailByID(int id, CinemaRoomDetail roomDatail) {
		Session session = null;
		Transaction trans = null;
		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			CinemaRoomDetail sea = session.get(CinemaRoomDetail.class, id);

			if (sea != null) {

				sea.setActiveDate(roomDatail.getActiveDate());
				sea.setRoomDescription(roomDatail.getRoomDescription());
				sea.setRoomRate(roomDatail.getRoomRate());
				sea.setCinemaRoomInfo(roomDatail.getCinemaRoomInfo());

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
	public void DeleteRoomDetailById(int id) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			CinemaRoomDetail room = session.get(CinemaRoomDetail.class, id);
			if (room != null) {
				session.delete(room);
				System.out.println("delete success");
			}

			trans.commit();
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
	public void InsertRoomDetail(CinemaRoomDetail roomDatail) {
		Session session = null;
		Transaction trans = null;

		try {
			session = factory.openSession();
			trans = session.beginTransaction();

			session.save(roomDatail);
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
