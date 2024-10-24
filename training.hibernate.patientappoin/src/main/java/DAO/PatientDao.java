package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.Patient;
import ultil.HibernateUltil;

public class PatientDao {
	static Scanner sc = new Scanner(System.in);
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void insert() {

		List<Patient> listPat = new ArrayList<>(
				Arrays.asList(new Patient("pat-001", "Nguyen", "Van Luong", "Cu chi", "Ho Chi Minh", "khong khoe"),
						new Patient("pat-002", "Tran", "Thanh Nhan", "Tan Binh", "Ho Chi Minh", "tot"),
						new Patient("pat-003", "Le", "Hong Nhung", "Quan 1", "Ho Chi Minh", "tot"),
						new Patient("pat-004", "Pham", "Thi Thuy", "Binh Tan", "Ho Chi Minh", "khong tot"),
						new Patient("pat-005", "Dang", "Quang Huy", "Go Vap", "Ho Chi Minh", "kha tot")));

		listPat.forEach(pat -> {
			Session session = null;
			Transaction transaction = null;
			try {
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(pat);
				transaction.commit();
				System.out.println("Patient created successfully!");
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
			Query<Patient> query = session.createQuery("FROM Patient", Patient.class);
			List<Patient> patient = query.getResultList();
			for (Patient p : patient) {
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

			System.out.println("Enter Patient ID to update: ");
			String patId = sc.nextLine();
			Patient patient = session.get(Patient.class, patId);

			if (patient != null) {
				System.out.println("Enter new Patient First Name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter new Patient Last Name: ");
				String lastName = sc.nextLine();
				System.out.println("Enter new Patient Address: ");
				String address = sc.nextLine();
				System.out.println("Enter new Patient City: ");
				String city = sc.nextLine();
				System.out.println("Enter new Patient State: ");
				String state = sc.nextLine();

				patient.setPat_first_name(firstName);
				patient.setPat_last_name(lastName);
				patient.setPat_address(address);
				patient.setPat_city(city);
				patient.setPat_sate(state);

				session.update(patient);
				transaction.commit();
				System.out.println("Patient updated syssessfully!!");
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

			System.out.println("Enter Patient ID to delete: ");
			String patId = sc.nextLine();
			Patient patient = session.get(Patient.class, patId);

			if (patient != null) {
				session.delete(patient);
				transaction.commit();
				System.out.println("Patient deleted successfully!");
			} else {
				System.out.println("Patient not found!");
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
