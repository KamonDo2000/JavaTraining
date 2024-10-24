package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IOLocalDate {
	private static Scanner sc = new Scanner(System.in);
	private static final String REGEX_DATE = "^(0[1-9]|[12][\\d]|3[01])-(0[1-9]|1[0-2])-(20[0-2][0-4]|19[\\d][\\d])$";

	private static boolean checkDate(String[] arrDate) {
		String yyyy = arrDate[2];
		String mm = arrDate[1];
		String dd = arrDate[0];

		if (checkExceptionDay(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd))) {
			return false;
		}

		return true;
	}

	private static boolean checkExceptionDay(int year, int mounth, int day) {
		if (checkLeapYear(year) && mounth == 2 && day > 29) {
			System.out.println("Leap year February has only 29 days!!");
			return true;
		} else if (!checkLeapYear(year) && mounth == 2 && day > 28) {
			System.out.println("February only has 28 days!!");
			return true;
		} else if (checkMounth30(mounth) && day > 30) {
			System.out.println("Month has only 30 days!!");
			return true;
		} else if (checkMounth31(mounth) && day > 31) {
			System.out.println("Month has only 31 days!!");
			return true;
		}
		return false;
	}

	private static boolean checkLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	private static boolean checkMounth30(int mounth) {
		if (mounth == 4 || mounth == 6 || mounth == 9 || mounth == 11) {
			return true;
		}
		return false;
	}

	private static boolean checkMounth31(int mounth) {
		if (mounth == 1 || mounth == 3 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12) {
			return true;
		}
		return false;
	}

	/**
	 * Use t
	 * 
	 * @param 
	 * @return LocalDate
	 * @throws BirthdayException
	 */
	public static LocalDate input() throws BirthdayException {
		String[] arrDate;
		String date;
		System.out.print("\t(dd-mm-yyyy): ");
		date = sc.nextLine();
		if (date.matches(REGEX_DATE)) {
			arrDate = date.split("-");
			if (checkDate(arrDate)) {
				return LocalDate.parse(arrDate[2] + "-" + arrDate[1] + "-" + arrDate[0]);
			}
		}
		throw new BirthdayException("Date not matched validate (dd-mm-yyyy) and in 1900-2024!");
	}

	
	public static String ouput(LocalDate date) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return date.format(dateFormatter);
	}
}
