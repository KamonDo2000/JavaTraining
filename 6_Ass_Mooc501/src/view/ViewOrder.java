package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Order;

public class ViewOrder {
	static Scanner sc = new Scanner(System.in);
	private static final String RG_DATE = "^(20\\d\\d|19\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

	public static List<Order> listOrder() {
		List<Order> listO = new ArrayList<>();
		do {
			Order order = new Order();
			order.setNumber(inputNumber());
			order.setDate(inputDate());
			listO.add(order);

			String check;
			do {
				System.out.print("Do you want continue? (Y/N): ");
				check = sc.nextLine();
				if (!check.equalsIgnoreCase("y") && !check.equalsIgnoreCase("n")) {
					System.out.println("Phai Nhap (Y/N)");
					continue;
				}
				break;
			} while (true);

			if (check.equalsIgnoreCase("y")) {
				continue;
			} else {
				return listO;
			}
		} while (true);
	}

	private static String inputNumber() {
		do {
			try {
				System.out.print("+ number: ");
				String number = sc.nextLine();
				if (number.length() != 10) {
					System.err.println("lenght = 10");
					continue;
				}
				return number;
			} catch (Exception e) {
				System.err.println("nhap sai");
				continue;
			}
		} while (true);
	}

	private static LocalDate inputDate() {
		do {
			System.out.print("+ date: ");
			String date = sc.nextLine();
			if (!date.matches(RG_DATE)) {
				System.err.println("vd: yyyy-mm-dd");
				continue;
			}
			return LocalDate.parse(date);
		} while (true);
	}

}
