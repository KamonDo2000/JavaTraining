package DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.Appointment;
import entities.Bill;
import ultil.HibernateUltil;

public class BillDao {
	static Scanner sc = new Scanner(System.in);
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void hashCodes() {

		Bill bill1 = new Bill(1, LocalDate.parse("2022-10-24"), "Da Thanh Toan");
		Bill bill2 = new Bill(2, LocalDate.parse("2024-04-10"), "Chua Thanh Toan");
		Bill bill3 = new Bill(3, LocalDate.parse("2022-12-15"), "Da Thanh Toan");
		Bill bill4 = new Bill(4, LocalDate.parse("2021-04-24"), "Chua Thanh Toan");
		Bill bill5 = new Bill(5, LocalDate.parse("2022-05-24"), "Da Thanh Toan");

		insert(bill1, "apoi-001");
		insert(bill2, "apoi-006");
		insert(bill3, "apoi-003");
		insert(bill4, "apoi-004");
		insert(bill5, "apoi-005");

	}

	public static void insert(Bill hasBill, String appId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Appointment appointment = session.get(Appointment.class, appId);
			if (appointment == null) {
				System.out.println("Appointment with ID " + appId + " not found!");
				return;
			}
			Bill bill = new Bill(hasBill.getBill_number(), hasBill.getBill_date(), hasBill.getBill_status(),
					appointment);

			session.save(bill);
			transaction.commit();
			System.out.println("Bill created successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void readAll() {
		Session session = null;
		try {
			session = factory.openSession();
			Query<Bill> query = session.createQuery("FROM Bill", Bill.class);
			List<Bill> bill = query.getResultList();
			for (Bill p : bill) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void update() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			System.out.println("Enter bill number wanna update!");
			int billNumber = Integer.parseInt(sc.nextLine());
			Bill bill = session.get(Bill.class, billNumber);

			if (bill != null) {
				System.out.println("Enter new bill date (YYYY-MM-DD)");
				String dateStr = sc.nextLine();
				System.out.println("Enter new bill status: ");
				String status = sc.nextLine();

				bill.setBill_date(LocalDate.parse(dateStr));
				bill.setBill_status(status);

				session.update(bill);
				transaction.commit();
				System.out.println("Update successfully!");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void delete() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			System.out.println("Enter bill number wanna delete!");
			int billNumber = Integer.parseInt(sc.nextLine());
			Bill bill = session.get(Bill.class, billNumber);

			if (bill != null) {
				session.delete(bill);
				transaction.commit();
				System.out.println("Bill deleted successfully!");
			} else {
				System.out.println("Bill not found!");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void searchBillByDate() {
		do {
			Session session = null;
			try {
				session = factory.openSession();
				System.out.println("Enter bill created date (YYYY-MM-DD)!");
				String dateStr = sc.nextLine();
				LocalDate dateparse = LocalDate.parse(dateStr);

				String hql = "FROM Bill WHERE bill_date = :date";
				Query<Bill> query = session.createQuery(hql, Bill.class);
				query.setParameter("date", dateparse);

				List<Bill> list = query.getResultList();

				for (Bill bill : list) {
					System.out.println(bill.toString());
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			} finally {
				if (session != null) {
					session.close();
				}
			}
		} while (true);
	}

	public static void PagingOperation(int pageNum, int pageSize) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		int firstResult = (pageNum - 1) * pageSize;

		String hql = "FROM Bill";
		List<Bill> listBill = session.createQuery(hql, Bill.class).setFirstResult(firstResult).setMaxResults(pageSize)
				.getResultList();

		listBill.forEach(e -> {
			System.out.println(e.toString());
		});

		transaction.commit();
		session.close();
	}

}
