package view;

import java.util.Scanner;

import model.Customer;

public class ViewCustomer {
	static Scanner sc = new Scanner(System.in);

	private static final String RG_PHONE = "^[\\d]{10}$";

	public static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setName(inputName());
		customer.setPhoneNumber(inputPhoneNumber());
		customer.setAddress(inputAddress());
		System.out.println("Enter order infor: ");
		customer.setListCus(ViewOrder.listOrder());
		return customer;
	}

	private static String inputName() {
		System.out.print("Enter Name: ");
		return sc.nextLine();
	}

	private static String inputAddress() {
		System.out.print("Enter address: ");
		return sc.nextLine();
	}

	public static String inputPhoneNumber() {
		do {
			System.out.print("Enter phone: ");
			String phone = sc.nextLine();
			if (!phone.matches(RG_PHONE)) {
				System.err.println("Nhap 10 so!");
				continue;
			}
			return phone;
		} while (true);
	}

}
