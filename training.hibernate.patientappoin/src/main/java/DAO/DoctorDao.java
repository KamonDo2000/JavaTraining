package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Doctor;
import ultil.HibernateUltil;

public class DoctorDao {
	static Scanner sc = new Scanner(System.in);
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void insert() {

		List<Doctor> listDr = new ArrayList<>(Arrays.asList(new Doctor("Dr-001", "Nguyen", "Van Viet"),
				new Doctor("Dr-002", "Do", "Van L"), new Doctor("Dr-003", "Tran", "Van D"),
				new Doctor("Dr-004", "Kim", "Van F"), new Doctor("Dr-005", "Hoang", "Van C"),
				new Doctor("Dr-006", "Tran", "Van H"), new Doctor("Dr-007", "Ly", "Van X")));

		listDr.forEach(dr -> {
			Session session = null;
			Transaction transaction = null;
			try {
				session = factory.openSession();
				transaction = session.beginTransaction();

				session.save(dr);
				transaction.commit();
				System.out.println("Doctor created syssessfully!!");

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
		});
	}

	public static void readAll() {
		Session session = null;
		try {
			session = factory.openSession();
			List<Doctor> doctor = session.createQuery("FROM Doctor", Doctor.class).list();

			doctor.forEach(dr -> System.out.println(dr));
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

			System.out.println("Input Doctor number: ");
			String id = sc.nextLine();
			Doctor dor = session.get(Doctor.class, id);

			if (dor != null) {
				System.out.println("Input first name doctor: ");
				String firstDoc = sc.nextLine();
				System.out.println("Input last name doctor: ");
				String lastDoc = sc.nextLine();

				dor.setDoc_firstname(firstDoc);
				dor.setDoc_lastname(lastDoc);

				session.update(dor);
				transaction.commit();
				System.out.println("Doctor updated syssessfully!!");
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
		System.out.println("Input doctor number: ");
		String docNum = sc.nextLine();

		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Doctor doctor = session.get(Doctor.class, docNum);

			if (doctor != null) {
				session.delete(doctor);
				transaction.commit();
				System.out.println("Doctor deleted successfully!");
			} else {
				System.out.println("Doctor not found!");
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
}
