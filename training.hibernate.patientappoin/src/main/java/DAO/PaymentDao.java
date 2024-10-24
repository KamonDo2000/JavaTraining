package DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.Bill;
import entities.Patient;
import entities.Payment;
import ultil.HibernateUltil;

public class PaymentDao {
	static Scanner sc = new Scanner(System.in);
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void hashCodes() {
		Payment payment = new Payment("pay-001", LocalDate.parse("2024-03-12"), "banking", "200000");
		Payment payment1 = new Payment("pay-002", LocalDate.parse("2022-08-10"), "cash", "15000");
		Payment payment2 = new Payment("pay-003", LocalDate.parse("2021-09-22"), "visa", "300000");
		Payment payment3 = new Payment("pay-004", LocalDate.parse("2023-10-22"), "cash", "350000");
		Payment payment4 = new Payment("pay-005", LocalDate.parse("2024-01-21"), "banking", "928000");
		Payment payment5 = new Payment("pay-006", LocalDate.parse("2024-07-12"), "banking", "900000");

		insert(payment, 5, "pat-004");
		insert(payment1, 2, "pat-001");
		insert(payment2, 3, "pat-004");
		insert(payment3, 4, "pat-002");
		insert(payment4, 1, "pat-003");
		insert(payment5, 3, "pat-005");

	}

	public static void insert(Payment pay, int bill_number, String pat_id) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Bill bill = session.get(Bill.class, bill_number);
			if (bill == null) {
				System.out.println("Bill with number" + bill_number + "not found!");
				return;
			}
			Patient patient = session.get(Patient.class, pat_id);
			if (patient == null) {
				System.out.println("Patient with ID" + patient + "not found!");
				return;
			}

			Payment payment = new Payment(pay.getPay_receiptnum(), pay.getPay_date(), pay.getPay_method(),
					pay.getPay_amount(), patient, bill);

			session.save(payment);
			transaction.commit();
			System.out.println("Payment created successfully!");
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
			Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
			List<Payment> payment = query.getResultList();
			for (Payment p : payment) {
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

			System.out.println("Enter receipt number wanna update!");
			String receipt_number = sc.nextLine();
			Payment payment = session.get(Payment.class, receipt_number);

			if (payment != null) {
				System.out.println("Enter new pay amount)");
				String pay_amount = sc.nextLine();
				System.out.println("Enter new pay date (YYYY-MM-DD)");
				String dateStr = sc.nextLine();
				System.out.println("Enter new pay method: ");
				String pay_method = sc.nextLine();

				payment.setPay_amount(pay_amount);
				payment.setPay_date(LocalDate.parse(dateStr));
				payment.setPay_method(pay_method);

				session.update(payment);
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

			System.out.println("Enter receipt number wanna delete!");
			String receipt_number = sc.nextLine();
			Payment payment = session.get(Payment.class, receipt_number);

			if (payment != null) {
				session.delete(payment);
				transaction.commit();
				System.out.println("Payment deleted successfully!");
			} else {
				System.out.println("Payment not found!");
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

	public static void finAllPaymentByBill() {
		do {
			Session session = null;
			try {
				session = factory.openSession();

				System.out.println("Enter bill number!");
				int billNumber = Integer.parseInt(sc.nextLine());

				String hql = "FROM Bill WHERE billNumber = :bill_id";
				Query<Bill> query = session.createQuery(hql, Bill.class);
				Bill bill = query.setParameter("bill_id", billNumber).getSingleResult();

				if (bill == null) {
					System.out.println("Bill does not exist");
					return;
				} else {
					bill.getPayments().forEach(e -> {
						System.out.println(e.toString());
					});
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

}
