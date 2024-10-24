package view;

import java.util.Scanner;

public class Menu {
	private static Scanner sc = new Scanner(System.in);

	public static int mainMenu() {
		System.out.println("\n================ Main MENU ======================");
		System.out.println("1. insert Data");
		
		System.out.println("2. Doctor");
		System.out.println("3. Patient");
		System.out.println("4. Appointment");
		System.out.println("5. Bill");
		System.out.println("6. Payment");
		
		System.out.println("7. Search all Bills with a specific bill_date");
		System.out.println("8. Find all Payment belong a specific Bill");
		System.out.println("9. Paging operation for Bill");
		System.out.println("0. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 0 && num <= 9) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

	public static int menuDoctor() {
		System.out.println("\n****** Doctor menu ******");
		System.out.println("2. Display all Doctor");
		System.out.println("3. Update Doctor");
		System.out.println("4. DeleteDoctor");
		System.out.println("1. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 1 && num <= 4) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

	public static int menuPatient() {
		System.out.println("\n****** Patient menu ******");
		System.out.println("2. Display all Patients");
		System.out.println("3. Update Patient");
		System.out.println("4. Delete Patient");
		System.out.println("1. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 1 && num <= 4) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

	public static int menuAppointment() {
		System.out.println("\n****** Appoint menu ******");
		System.out.println("2. Display all Appointments");
		System.out.println("3. Update Appointment");
		System.out.println("4. Delete Appointment");
		System.out.println("1. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 1 && num <= 4) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

	public static int menuBill() {
		System.out.println("\n****** Bill menu ******");
		System.out.println("2. Display all bill");
		System.out.println("3. Update bill");
		System.out.println("4. Delete bill");
		System.out.println("1. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 1 && num <= 4) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

	public static int menuPayment() {
		System.out.println("\n****** Payment menu ******");
		System.out.println("2. Display all Payment");
		System.out.println("3. Update Payment");
		System.out.println("4. Delete Payment");
		System.out.println("1. Exit");
		do {
			try {
				System.out.print("Enter your choice: ");
				int num = Integer.parseInt(sc.nextLine());
				if (num >= 1 && num <= 4) {
					return num;
				} else {
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice! Please try again.");
			}
		} while (true);
	}

}
