package utils;

import java.util.Scanner;

public class Validator {
	private static final String RX_PHONE = "^([\\d]{7,9}$)";
	private static final String RX_CANDIDATEID = "^((?:FR|IN|EX)\\d{3,8}$)";
	private static final String RX_NUMBER_ORDER = "^([\\d]{10}$)";
	private static final String RX_EMAIL = "^[a-zA-Z0-9].[a-zA-Z0-9\\._%\\+\\-]{0,63}@[a-zA-Z0-9\\.\\-]+\\.[a-zA-Z]{2,30}$";
	static Scanner scanner = new Scanner(System.in);

	public static boolean isMatchRegexEmail(String email) {
		if (email.matches(RX_EMAIL)) {
			return false;
		}
		return true;
	}

	public static boolean isMatchRegexPhone(String phone) {
		if (phone.matches(RX_PHONE)) {
			return false;
		}
		return true;
	}

	public static boolean isMatchRegexCandidateID(String phone) {
		if (phone.matches(RX_CANDIDATEID)) {
			return false;
		}
		return true;
	}

	public static boolean isMatchRegexNumberOrder(String number) {
		if (number.matches(RX_NUMBER_ORDER)) {
			return false;
		}
		return true;
	}

	public static String inputCandidateID() {

		String number = scanner.next();
		while (Validator.isMatchRegexCandidateID(number)) {
			System.out.println("Candidate ID not match with format. Please try again !!!");
			number = scanner.next();
		}
		return number;
	}

	public static boolean checkEmail(String email) throws EmailException {
		if (isMatchRegexEmail(email)) {
			throw new EmailException("Email is invalid !!!");
		}
		return true;
	}
}
