package view;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputDateView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_YEAR = "^(1[5-9]\\d\\d|20\\d\\d)$";
	private static final String REGEX_MOUNTH = "^(0[1-9]|1[0-2])$";
	private static final String REGEX_DAY = "^(0[1-9]|[1-2]\\d|3[01])$";

	public static LocalDate inputDate() {
		Pattern rgDay = Pattern.compile(REGEX_DAY);
		Pattern rgMounth = Pattern.compile(REGEX_MOUNTH);
		Pattern rgYear = Pattern.compile(REGEX_YEAR);

		System.out.println("Nhập thời gian phát hành: ");
		String dd;
		String mm;
		String yyyy;

		do {
			System.out.print("\tYear: ");
			yyyy = sc.nextLine();
			if (rgYear.matcher(yyyy).find()) {
				break;
			}
			System.out.println("\nNăm từ 1500 đến 2099");
		} while (true);

		do {
			System.out.print("\tMounth: ");
			mm = sc.nextLine();
			if (rgMounth.matcher(mm).find()) {
				break;
			}
			System.out.println("\nTháng từ 01 đến 12");
		} while (true);

		do {
			System.out.print("\tDay: ");
			dd = sc.nextLine();
			if (rgDay.matcher(dd).find()) {
				if (checkExceptionDay(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd))) {
					continue;
				}
				break;
			}
			System.out.println("\nNgày từ 01 đến 31");
		} while (true);

		String str = yyyy + "-" + mm + "-" + dd;

		return LocalDate.parse(str);
	}

	private static boolean checkExceptionDay(int year, int mounth, int day) {
		if (checkLeapYear(year) && mounth == 2 && day > 29) {
			System.out.println("Năm nhuận tháng 2 chỉ có 29 ngày!!");
			return true;
		} else if (!checkLeapYear(year) && mounth == 2 && day > 28) {
			System.out.println("Tháng 2 chỉ có 28 ngày!!");
			return true;
		} else if (checkMounth30(mounth) && day > 30) {
			System.out.println("Tháng chỉ có 30 ngày!!");
			return true;
		} else if (checkMounth31(mounth) && day > 31) {
			System.out.println("Tháng chỉ có 31 ngày!!");
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

}
