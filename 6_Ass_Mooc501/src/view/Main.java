package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Customer> listCus = new ArrayList<>();
		do {
			int choise = menu();

			switch (choise) {
			case 1:
				System.out.println("----Enter Customer information------");
				listCus.add(ViewCustomer.createCustomer());

				continue;
			case 2:
				System.out.println("----LIST OF Customer------");
				List<String> listC = findAll(listCus);
				for (String s : listC) {
					System.out.println(s);
				}

				display(listCus);
				continue;
			case 3:
				System.out.println("----Search Customer------");
				String phone = ViewCustomer.inputPhoneNumber();

				List<String> listString = search(phone, listCus);
				for (String s : listString) {
					System.out.println(s);
				}
				continue;
			case 4:
				System.out.println("----Remove Customer------");
				String phoneDelete = ViewCustomer.inputPhoneNumber();
				remove(phoneDelete, listCus);
				continue;
			case 5:
				System.out.println("----Input file name------");
				System.out.print("Nhap Ten file: ");
				String fileName = sc.nextLine();
				OutputToFile.outputToFile(fileName, listCus);
				continue;
			case 6:
				return;
			default:
				continue;
			}

		} while (true);

	}

	private static int menu() {
		do {
			System.out.println("\n");
			System.out.println("Choose function: ");
			System.out.println("1. Add a new Customer");
			System.out.println("2. Show all Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Remove Customer");
			System.out.println("5. write to the file");
			System.out.println("6. Exits");
			System.out.print("You choise: ");

			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Do not choise.");
				continue;
			}
		} while (true);
	}

	public static void display(List<Customer> listS) {
		System.out.println("Customer Name \t Address \t Phone Number \t OrderList");

		for (Customer s : listS) {
			System.out.println(s.getName() + "\t" + s.getAddress() + "\t" + s.getPhoneNumber() + "\t" + s.getListCus());
		}
	}

	public static List<String> findAll(List<Customer> listCus) {
		List<String> listC = new ArrayList<>();
		for (Customer c : listCus) {
			listC.add(c.toString());
		}
		return listC;
	}

	public static List<String> search(String phone, List<Customer> listCus) {
		List<String> listC = new ArrayList<>();
		for (Customer c : listCus) {
			if (c.getPhoneNumber().equalsIgnoreCase(phone)) {
				listC.add(c.toString());
			}
		}
		return listC;
	}

	public static List<Customer> remove(String phone, List<Customer> listCus) {
		for (Customer c : listCus) {
			if (c.getPhoneNumber().equalsIgnoreCase(phone)) {
				listCus.remove(c);
			}
		}
		return listCus;
	}
}
