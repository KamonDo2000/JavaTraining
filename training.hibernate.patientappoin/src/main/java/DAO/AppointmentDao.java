package DAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Appointment;
import entities.Doctor;
import entities.Patient;
import ultil.HibernateUltil;

public class AppointmentDao {
	static Scanner sc = new Scanner(System.in);
	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void hashCodes() {
		Appointment appointment = new Appointment("apoi-001", LocalDate.parse("2022-02-22"),
				LocalTime.parse("15:33:23"), "1 hour", "dau bung");
		Appointment appointment1 = new Appointment("apoi-002", LocalDate.parse("2020-09-20"),
				LocalTime.parse("19:30:23"), "1 hour", "dau bung");
		Appointment appointment2 = new Appointment("apoi-003", LocalDate.parse("2022-02-22"),
				LocalTime.parse("15:33:23"), "1 hour", "dau bung");
		Appointment appointment3 = new Appointment("apoi-004", LocalDate.parse("2021-09-20"),
				LocalTime.parse("04:30:23"), "1 hour", "dau bung");
		Appointment appointment4 = new Appointment("apoi-005", LocalDate.parse("2020-02-22"),
				LocalTime.parse("10:33:23"), "1 hour", "dau bung");
		Appointment appointment5 = new Appointment("apoi-006", LocalDate.parse("2019-09-20"),
				LocalTime.parse("20:30:23"), "1 hour", "dau bung");
		Appointment appointment6 = new Appointment("apoi-007", LocalDate.parse("2020-09-20"),
				LocalTime.parse("19:30:23"), "1 hour", "dau bung");
		Appointment appointment7 = new Appointment("apoi-008", LocalDate.parse("2022-02-22"),
				LocalTime.parse("15:33:23"), "1 hour", "dau bung");
		Appointment appointment8 = new Appointment("apoi-009", LocalDate.parse("2021-09-20"),
				LocalTime.parse("04:30:23"), "1 hour", "dau bung");
		Appointment appointment9 = new Appointment("apoi-010", LocalDate.parse("2020-02-22"),
				LocalTime.parse("10:33:23"), "1 hour", "dau bung");

		insert(appointment, "Dr-002", "pat-001");
		insert(appointment1, "Dr-003", "pat-002");
		insert(appointment2, "Dr-003", "pat-005");
		insert(appointment3, "Dr-003", "pat-003");
		insert(appointment4, "Dr-003", "pat-004");
		insert(appointment5, "Dr-001", "pat-001");
		insert(appointment6, "Dr-005", "pat-005");
		insert(appointment7, "Dr-004", "pat-003");
		insert(appointment8, "Dr-007", "pat-004");
		insert(appointment9, "Dr-006", "pat-001");
	}

	public static void insert(Appointment appoi, String docId, String patId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			// Retrieve doctor object
			Doctor doctor = session.get(Doctor.class, docId);
			if (doctor == null) {
				System.out.println("Doctor with ID " + docId + " not found!");
				return;
			}
			Patient patient = session.get(Patient.class, patId);
			if (patient == null) {
				System.out.println("Patient with ID " + patId + " not found!");
				return;
			}

			Appointment appointment = new Appointment(appoi.getApp_id(), appoi.getApp_date(), appoi.getApp_time(),
					appoi.getApp_duration(), appoi.getApp_reason(), doctor, patient);

			session.save(appointment);
			transaction.commit();
			System.out.println("Appointment created successfully!");
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
			List<Appointment> listapoi = session.createQuery("FROM Appointment", Appointment.class).list();

			if (listapoi != null) {
				listapoi.forEach(e -> System.out.println(e.toString()));
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

			System.out.println("Enter Appointment ID to update: ");
			String appId = sc.nextLine();
			Appointment appointment = session.get(Appointment.class, appId);

			if (appointment != null) {
				System.out.println("Enter new Appointment Date (YYYY-MM-DD): ");
				String appDateStr = sc.nextLine();
				System.out.println("Enter new Appointment Time (HH:MM:SS): ");
				String appTimeStr = sc.nextLine();
				System.out.println("Enter new Appointment Duration: ");
				String appDuration = sc.nextLine();
				System.out.println("Enter new Appointment Reason: ");
				String appReason = sc.nextLine();

				// Parse strings to appropriate data types and update the appointment
				appointment.setApp_date(LocalDate.parse(appDateStr));
				appointment.setApp_time(LocalTime.parse(appTimeStr));
				appointment.setApp_duration(appDuration);
				appointment.setApp_reason(appReason);

				session.update(appointment);
				transaction.commit();
				System.out.println("Appointment updated successfully!");
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

			System.out.println("Enter Appointment ID to delete: ");
			String appId = sc.nextLine();
			Appointment appointment = session.get(Appointment.class, appId);

			if (appointment != null) {
				session.delete(appointment);
				transaction.commit();
				System.out.println("Appointment deleted successfully!");
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
