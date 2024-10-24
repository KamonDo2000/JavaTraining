package view;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.CheckBookModel;

public class InsertBookView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_ID = "^\\d{4}$";
	private static final String REGEX_TITLE = "^.{6,}$";
	private static final String REGEX_AUTHOR = "^[a-zA-Z ]{6,}$";
	private static final String REGEX_DAY = "^(0[1-9]|[1-2]\\d|3[01])$";
	private static final String REGEX_MOUNTH = "^(0[1-9]|1[0-2])$";
	private static final String REGEX_YEAR = "^(1[5-9]\\d\\d|20\\d\\d)$";
	private static final String REGEX_STATUS = "^[0-1]$";

	public static int inputID(Connection conn) {
		Pattern rgID = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập ID: ");
				String id = sc.nextLine();
				if (!rgID.matcher(id).find()) {
					System.out.println("ID là số có 4 ký tự!!");
				} else if (CheckBookModel.checkID(conn, Integer.parseInt(id))) {
					System.out.println("Đã có nhân viên ID này");
				} else {
					return Integer.parseInt(id);
				}
			} catch (Exception e) {
				System.out.println("Phải là một số!!");
			}
		} while (true);
	}

	public static String inputTitle() {
		Pattern rgTitle = Pattern.compile(REGEX_TITLE);
		do {
			try {
				System.out.println("Input Title for Book: ");
				String title = sc.nextLine();
				if (rgTitle.matcher(title).find()) {
					return title.trim();
				} else {
					System.out.println("Tên ít nhất 6 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("Ít nhất 6 ký tự!!");
			}
		} while (true);
	}

	public static String inputAuthor() {
		Pattern rgAuthor = Pattern.compile(REGEX_AUTHOR);
		do {
			try {
				System.out.println("Input name author: ");
				String author = sc.nextLine();
				if (rgAuthor.matcher(author).find()) {
					return author.trim();
				} else {
					System.out.println("Chỉ được nhập ký tự và ít nhất 6 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("Chỉ được nhập ký tự và ít nhất 6 ký tự!!");
			}
		} while (true);
	}

	public static LocalDate inputDate() {
		Pattern rgDay = Pattern.compile(REGEX_DAY);
		Pattern rgMounth = Pattern.compile(REGEX_MOUNTH);
		Pattern rgYear = Pattern.compile(REGEX_YEAR);

		System.out.println("Nhập thời gian phát hành: ");
		String dd;
		String mm;
		String yyyy;
		do {
			System.out.print("\tDay: ");
			dd = sc.nextLine();
			if (rgDay.matcher(dd).find()) {
				break;
			}
			System.out.println("\nNgày từ 01 đến 31");
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
			System.out.print("\tYear: ");
			yyyy = sc.nextLine();
			if (rgYear.matcher(yyyy).find()) {
				break;
			}
			System.out.println("\nNăm từ 1500 đến 2099");
		} while (true);

		String str = yyyy + "-" + mm + "-" + dd;

		return LocalDate.parse(str);
	}

	public static float inputPrice() {
		do {
			try {
				System.out.println("Nhập giá của Book: ");
				String price = sc.nextLine();
				if (Float.parseFloat(price) > 10 && Float.parseFloat(price) < 10000) {
					return Float.parseFloat(price);
				} else {
					System.out.println("Giá lớn hơn 10.00 USD và bé hơn 10.000 USD!!");
				}

			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

	public static int inputQuatity() {
		do {
			try {
				System.out.println("Nhập Số lượng book: ");
				String quatity = sc.nextLine();
				if (Integer.parseInt(quatity) > 1 && Integer.parseInt(quatity) < 100) {
					return Integer.parseInt(quatity);
				} else {
					System.out.println("1 < SL < 100!!!");
				}

			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

	public static int inputStatus() {
		do {
			Pattern rgStatus = Pattern.compile(REGEX_STATUS);
			try {
				System.out.println("Nhập tình trạng book (1: còn hàng || 0: hết hàng): ");
				String status = sc.nextLine();
				if (rgStatus.matcher(status).find()) {
					return Integer.parseInt(status);
				} else {
					System.out.println("chỉ lựa chọn 0 hoặc 1");
				}

			} catch (Exception e) {
				System.out.println("chỉ lựa chọn 0 hoặc 1");
			}
		} while (true);
	}

}
