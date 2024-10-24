package view;

import java.util.Scanner;

public class InputData {
	static Scanner sc = new Scanner(System.in);

	private static final String RX_ID = "^[a-zA-Z0-9]{5}$";
	private static final String RX_GEN = "^[0-1]$";
	private static final String RX_PHONE = "^[\\d]{10}$";
	private static final String RX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";
	private static final String RX_NAME = "^[a-zA-Z ]{5,}$";

	public static String inputID() {
		String idPer;
		do {
			System.out.println("Nhap ma cua hoc sinh");
			idPer = sc.nextLine();
			if (!idPer.matches(RX_ID)) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (!idPer.matches(RX_ID));
		return idPer;
	}

	public static String inGender() {
		String gender;
		do {
			System.out.println("Nhap gioi tinh 0:Nam 1:Nu");
			gender = sc.nextLine();
			if (!gender.matches(RX_GEN)) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (!gender.matches(RX_GEN));

		if (gender.equals("1")) {
			return "Nu";
		} else {
			return "Nam";
		}
	}

	public static String inPhone() {
		String num;
		do {
			System.out.println("Nhap so dien thoai");
			num = sc.nextLine();
			if (!num.matches(RX_PHONE)) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (!num.matches(RX_PHONE));
		return num;
	}

	public static String inEmail() {
		String mail;
		do {
			System.out.println("Nhap email");
			mail = sc.nextLine();
			if (!mail.matches(RX_EMAIL)) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (!mail.matches(RX_EMAIL));
		return mail;
	}

	public static String inputName() {
		String name;
		do {
			System.out.println("Nhap Ten");
			name = sc.nextLine();
			if (!name.matches(RX_NAME)) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (!name.matches(RX_NAME));
		return name;
	}

	public static double inputTheory() {
		double theory = -1;
		do {
			System.out.println("Nhap theory");
			try {
				theory = Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.err.println("nhap sai nhap lai!");
				continue;
			}

			if (theory < 0 || theory > 10) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (theory < 0 || theory > 10);
		return theory;
	}

	public static double inputPractice() {
		double practice = -1;
		do {
			System.out.println("Nhap practice");
			try {
				practice = Double.parseDouble(sc.nextLine());				
			} catch (Exception e) {
				System.err.println("nhap sai nhap lai!");
				continue;
			}

			if (practice < 0 || practice > 10) {
				System.err.println("nhap sai nhap lai!");
			}
		} while (practice < 0 || practice > 10);
		return practice;
	}

	public static double inputSalary() {
		double basicSalary = 0;
		do {
			System.out.println("Nhap Salary");
			try {
				basicSalary = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.err.println("nhap sai nhap lai!");
				continue;
			}
		} while (true);
		return basicSalary;
	}

	public static double inputSubsidy() {
		double subsidy;
		do {
			System.out.println("Nhap Subsidy");
			try {
				subsidy = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.err.println("nhap sai nhap lai!");
				continue;
			}
		} while (true);
		return subsidy;
	}

}
