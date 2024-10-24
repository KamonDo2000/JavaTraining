package view;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputDateView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_YEAR = "^(1[5-9]\\d\\d|20\\d\\d)$";
	private static final String REGEX_MOUNTH = "^(0[1-9]|1[0-2])$";
	private static final String REGEX_DAY = "^(0[1-9]|[1-2]\\d|3[01])$";

	/**
	 * Nhập Tháng
	 * 
	 * @return một tháng (int)
	 */
	public static int inputMounth() {
		String mm;
		Pattern rgMounth = Pattern.compile(REGEX_MOUNTH);
		do {
			System.out.print("\tTháng: ");
			mm = sc.nextLine();
			if (rgMounth.matcher(mm).find()) {
				break;
			}
			System.err.println("\nTháng từ 01 đến 12");
		} while (true);
		return Integer.parseInt(mm);
	}

	/**
	 * Nhập Năm
	 * 
	 * @return một năm (int)
	 */
	public static int inputYear() {
		String yyyy;
		Pattern rgYear = Pattern.compile(REGEX_YEAR);
		do {
			System.out.print("\tNăm: ");
			yyyy = sc.nextLine();
			if (rgYear.matcher(yyyy).find()) {
				break;
			}
			System.err.println("\nNăm từ 1500 đến 2099");
		} while (true);
		return Integer.parseInt(yyyy);
	}

	/**
	 * Nhập Ngày Tháng Năm
	 * 
	 * @return định dạng YYYY-MM-DD (LocalDate)
	 */
	public static LocalDate inputNgay() {
		Pattern rgDay = Pattern.compile(REGEX_DAY);
		Pattern rgMounth = Pattern.compile(REGEX_MOUNTH);
		Pattern rgYear = Pattern.compile(REGEX_YEAR);

		System.out.println("Nhập ");
		String dd;
		String mm;
		String yyyy;

		do {
			System.out.print("\tNăm: ");
			yyyy = sc.nextLine();
			if (rgYear.matcher(yyyy).find()) {
				break;
			}
			System.err.println("\nNăm từ 1500 đến 2099");
		} while (true);

		do {
			System.out.print("\tTháng: ");
			mm = sc.nextLine();
			if (rgMounth.matcher(mm).find()) {
				break;
			}
			System.err.println("\nTháng từ 01 đến 12");
		} while (true);

		do {
			System.out.print("\tNgày: ");
			dd = sc.nextLine();
			if (rgDay.matcher(dd).find()) {
				if (checkExceptionDay(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd))) {
					continue;
				}
				break;
			}
			System.err.println("\nNgày từ 01 đến 31");
		} while (true);

		String str = yyyy + "-" + mm + "-" + dd;

		return LocalDate.parse(str);
	}

	/**
	 * Kiểm tra ngày tháng Hợp lý chưa
	 * 
	 * @param year
	 * @param mounth
	 * @param day
	 * @return
	 */
	private static boolean checkExceptionDay(int year, int mounth, int day) {
		if (checkLeapYear(year) && mounth == 2 && day > 29) {
			System.err.println("Năm nhuận tháng 2 chỉ có 29 ngày!!");
			return true;
		} else if (!checkLeapYear(year) && mounth == 2 && day > 28) {
			System.err.println("Tháng 2 chỉ có 28 ngày!!");
			return true;
		} else if (checkMounth30(mounth) && day > 30) {
			System.err.println("Tháng chỉ có 30 ngày!!");
			return true;
		} else if (checkMounth31(mounth) && day > 31) {
			System.err.println("Tháng chỉ có 31 ngày!!");
			return true;
		}
		return false;
	}

	/**
	 * Kiểm tra năm nhuận
	 * 
	 * @param year
	 * @return
	 */
	private static boolean checkLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Kiểm tra tháng 30 days
	 * 
	 * @param mounth
	 * @return
	 */
	private static boolean checkMounth30(int mounth) {
		if (mounth == 4 || mounth == 6 || mounth == 9 || mounth == 11) {
			return true;
		}
		return false;
	}

	/**
	 * Kiểm tra tháng 31 days
	 * 
	 * @param mounth
	 * @return
	 */
	private static boolean checkMounth31(int mounth) {
		if (mounth == 1 || mounth == 3 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12) {
			return true;
		}
		return false;
	}

}
