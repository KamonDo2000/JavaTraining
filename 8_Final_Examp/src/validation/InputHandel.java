package validation;

import java.util.Scanner;

public class InputHandel {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_TEXT = "^[a-zA-Z ]{1,250}$";// do the gia huy
	private static final String REGEX_NUMBER = "^\\d+$";
	private static final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$"; // huydo@gmail.com.vn
	private static final String REGEX_PHONE = "^(090|098|091|031|035|038)\\d{7}$";
	private static final String REGEX_SEX = "^[10]$";

	@SuppressWarnings("unused")
	private static final String REGEX_TETs = "^(09[08])(09[13]|03[158])\\d{7}$";

	/**
	 * Use to validation input text
	 * 
	 * @return text A-z and space
	 * @throws CharratingException
	 */
	public static String text() {
		do {
			String text = sc.nextLine();
			try {
				if (text.matches(REGEX_TEXT)) {
					return text;
				}
				throw new CharratingException("Only input a-z and space!!");
			} catch (CharratingException e) {
				System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
				System.err.println(e);
				System.err.print("\tretype: ");
				continue;
			}

		} while (true);
	}

	/**
	 * Use to validation input number
	 * 
	 * @return text 0-9
	 * @throws NumberException
	 */
	public static String number() {
		do {
			String num = sc.nextLine();
			try {
				if (num.matches(REGEX_NUMBER)) {
					return num;
				}
				throw new NumberException("Only input 0-9!!");
			} catch (NumberException e) {
				System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
				System.err.println(e);
				System.err.print("\tretype: ");
			}

		} while (true);
	}

	/**
	 * Use to validation input email
	 * 
	 * @return email validate
	 * @throws EmailException
	 */
	public static String email() {
		System.out.print("Input Email: ");
		do {
			try {
				String mail = sc.nextLine();

				if (mail.matches(REGEX_EMAIL)) {
					return mail;
				}

				throw new EmailException("\n\tEmail invalid! EX: abc@gmail.com.vn");
			} catch (Exception e) {
				System.err.println(e);
				System.err.print("\tretype: ");
				continue;
			}
		} while (true);
	}

	/**
	 * Use to validation input phone number
	 * 
	 * @return phone validate
	 * @throws NumPhoneException
	 */
	public static String phone() {
		System.out.print("Input number Phone: ");
		do {
			try {
				String phone = sc.nextLine();

				if (phone.matches(REGEX_PHONE)) {
					return phone;
				}

				throw new NumPhoneException("\n\tPhone number is 10 digits and start with (090|098|091|031|035|038)");
			} catch (Exception e) {
				System.err.println(e);
				System.err.print("\tretype: ");
				continue;
			}
		} while (true);
	}

	/**
	 * Use to validation input choosen sex
	 * 
	 * @return Male or Female
	 * @throws SexException
	 */
	public static String sex() {
		do {
			System.out.println("Input choosen: ");
			System.out.println("0. Male ");
			System.out.println("1. Female ");
			System.out.print("You is: ");
			try {
				String sex = sc.nextLine();

				if (!sex.matches(REGEX_SEX)) {
					throw new SexException("\n\tOnly input 0 with Male OR 1 with Female!");
				} else if (sex.equalsIgnoreCase("1")) {
					return "Female";
				} else {
					return "Male";
				}
			} catch (Exception e) {
				System.err.println(e);
				System.err.print("\tretype: ");
				continue;
			}
		} while (true);
	}
}
