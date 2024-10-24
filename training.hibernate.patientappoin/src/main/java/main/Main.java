package main;

import DAO.AppointmentDao;
import DAO.BillDao;
import DAO.DoctorDao;
import DAO.PatientDao;
import DAO.PaymentDao;
import view.Menu;

public class Main {

	public static void main(String[] args) {
		do {
			switch (Menu.mainMenu()) {
			case 1:
				DoctorDao.insert();
				PatientDao.insert();
				AppointmentDao.hashCodes();
				BillDao.hashCodes();
				PaymentDao.hashCodes();
				break;

			case 2:
				crudDoctor();
				break;
			case 3:
				crudPatient();
				break;
			case 4:
				crudAppointment();
				break;
			case 5:
				crudBill();
				break;
			case 6:
				crudPayment();
				break;

			case 7:
				BillDao.searchBillByDate();
				break;
			case 8:
				PaymentDao.finAllPaymentByBill();
				break;

			case 9:
				int pageNum = 2;
				int pageSize = 2;
				BillDao.PagingOperation(pageNum, pageSize);
				break;

			case 0:
				System.out.println("Exit!");
				return;
			default:
			}
		} while (true);
	}

	private static void crudDoctor() {
		do {
			switch (Menu.menuDoctor()) {
			case 1:
				System.out.println("Exit!");
				return;
			case 2:
				DoctorDao.readAll();
				break;
			case 3:
				DoctorDao.update();
				break;
			case 4:
				DoctorDao.delete();
				break;
			default:
			}
		} while (true);
	}

	private static void crudPatient() {
		do {
			switch (Menu.menuPatient()) {
			case 1:
				System.out.println("Exit!");
				return;
			case 2:
				PatientDao.readAll();
				break;
			case 3:
				PatientDao.update();
				break;
			case 4:
				PatientDao.delete();
				break;
			default:
			}
		} while (true);
	}

	private static void crudAppointment() {
		do {
			switch (Menu.menuAppointment()) {
			case 1:
				System.out.println("Exit!");
				return;
			case 2:
				AppointmentDao.readAll();
				break;
			case 3:
				AppointmentDao.update();
				break;
			case 4:
				AppointmentDao.delete();
				break;
			default:
			}
		} while (true);
	}

	private static void crudBill() {
		do {
			switch (Menu.menuBill()) {
			case 1:
				System.out.println("Exit!");
				return;
			case 2:
				BillDao.readAll();
				break;
			case 3:
				BillDao.update();
				break;
			case 4:
				BillDao.delete();
				break;
			default:
			}
		} while (true);
	}

	private static void crudPayment() {
		do {
			switch (Menu.menuPayment()) {
			case 1:
				System.out.println("Exit!");
				return;
			case 2:
				PaymentDao.readAll();
				break;
			case 3:
				PaymentDao.update();
				break;
			case 4:
				PaymentDao.delete();
				break;

			default:
			}
		} while (true);
	}

}
