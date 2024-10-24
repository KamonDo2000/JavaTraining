package view;

import java.time.LocalDate;
import java.util.Scanner;

public class InputData {

	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_TEXT = "^[a-zA-Z ]{1,50}$";// do the gia huy
	private static final String REGEX_NUMBER = "^\\d+$";
	private static final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$"; // huydo@gmail.com.vn
	private static String inputText() {
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

	private static String inputNumber() {
		do {
			String num = sc.nextLine();
			try {
				if (num.matches(REGEX_NUMBER)) {
					return num;
				}
				throw new NUmberException("Only input 0-9!!");
			} catch (NUmberException e) {
				System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
				System.err.println(e);
				System.err.print("\tretype: ");
			}

		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inCandidateID() {
		do {
			System.out.print("Input CandidateID: ");
			String canID = inputNumber();
			if (canID.length() == 5) {
				return canID;
			}
			System.err.println("\n Only input 5 character EX: 00001!");
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inFullName() {
		System.out.print("Input Full Name: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static LocalDate inBirthDay() {
		System.out.println("Input Birth Day: ");
		do {
			try {
				return IOLocalDate.input();
			} catch (BirthdayException e) {
				System.err.println(e);
				continue;
			}
		} while (true);

	}

	/**
	 * 
	 * @return
	 */
	public static String inPhone() {
		System.out.print("Input Phone number: ");
		do {
			String phone = inputNumber();
			if (phone.length() == 10) {
				return phone;
			}
			System.err.println("\n\tphone number invalid! EX: 0774053798");
			System.err.print("\tretype: ");
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inEmail() {
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
	 * 
	 * @return
	 */
	public static int inExpInYear() {
		System.out.print("Input Exp In Year: ");
		do {
			int expY = Integer.parseInt(inputNumber());
			if (expY < 100) {
				return expY;
			}
			System.err.println("\n\tExp In Year invalid! Value < 100");
			System.err.print("\tretype: ");
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inProSkill() {
		System.out.print("Input Pro Skill: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static LocalDate inGraduationDate() {
		System.out.println("Input Graduation Date: ");

		do {
			try {
				return IOLocalDate.input();
			} catch (BirthdayException e) {
				System.err.println(e);
				continue;
			}
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inGraduationRank() {
		System.out.print("Input graduation Rank: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static String inEducation() {
		System.out.print("Input Education: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static String inMajors() {
		System.out.print("Input Majors: ");
		return inputText();
	}

	/**
	 * input hoc ky
	 * 
	 * @return
	 */
	public static int inSemester() {
		System.out.print("Input semester: ");
		do {
			int semp = Integer.parseInt(inputNumber());
			if (semp <= 8) {
				return semp;
			}
			System.err.println("\n\tsemester invalid! Value <= 8");
			System.err.print("\tretype: ");
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inUniversityName() {
		System.out.print("Input universityName: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static String inCertificatedID() {
		do {
			System.out.print("Input Certificated ID: ");
			String canID = inputNumber();
			if (canID.length() == 5) {
				return canID;
			}
			System.err.println("\n Only input 5 character EX: 00001!");
		} while (true);
	}

	/**
	 * 
	 * @return
	 */
	public static String inCertificateName() {
		System.out.print("Input Certificate Name: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static String inCertificateRank() {
		System.out.print("Input certificate Rank: ");
		return inputText();
	}

	/**
	 * 
	 * @return
	 */
	public static LocalDate inCertificatedDate() {
		System.out.println("Input Certificated Date: ");
		do {
			try {
				return IOLocalDate.input();
			} catch (BirthdayException e) {
				System.err.println(e);
				continue;
			}
		} while (true);
	}
}
