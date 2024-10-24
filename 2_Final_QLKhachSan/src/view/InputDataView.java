package view;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import services.CheckDataModel;

public class InputDataView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_ID = "^[Dd][Pp]\\d{5}$";
	private static final String REGEX_NAMED = "^[a-zA-Z0-9 ]{2,}$";
	private static final String REGEX_NAME = "^[a-zA-Z ]{2,}$";
	private static final String REGEX_PHONG = "^[Pp]\\d{3}$";

	private static final String REGEX_CMND = "^02\\d{10}$";

	/**
	 * Hàm nhập IDCTDP đã tồn tại để Update
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputIDUpdate(Connection conn) {
		Pattern regex = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.print("Nhập ID đặt phòng: ");
				String id = sc.nextLine();
				if (!regex.matcher(id).find()) {
					System.err.println("Cú pháp DPxxxxx, xxxxx là số!!");
				} else if (!CheckDataModel.checkIDCTDP(conn, id)) {
					System.err.println("Không tồn tại ID đặt phòng này");
				} else {
					return id.trim();
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập ID " + e);
			}
		} while (true);
	}

	/**
	 * Hàm nhập IDCTDP đã tồn tại để Delete
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputIDDelete(Connection conn) {
		Pattern regex = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.print("Nhập ID đặt phòng: ");
				String id = sc.nextLine();
				if (!regex.matcher(id).find()) {
					System.err.println("Cú pháp DPxxxxx, xxxxx là số!!");
				} else if (!CheckDataModel.checkIDCTDP(conn, id)) {
					return "quit";
				} else {
					return id.trim();
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập ID " + e);
			}
		} while (true);
	}

	/**
	 * Hàm nhập ID của Phòng
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputIDPhong() {
		Pattern regex = Pattern.compile(REGEX_PHONG);
		do {
			try {
				System.out.println("Nhập ID phòng: ");
				String idPhong = sc.nextLine();
				if (regex.matcher(idPhong).find()) {
					return idPhong.trim();
				} else {
					System.err.println("ID phòng định dang Pxxx x là số!!");
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập tên đoàn " + e);
			}
		} while (true);
	}

	/**
	 * Hàm nhập Tên của đoàn đặt phòng
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputTenDoan() {
		Pattern regex = Pattern.compile(REGEX_NAMED);
		do {
			try {
				System.out.println("Nhập tên Đoàn booking: ");
				String name = sc.nextLine();
				if (regex.matcher(name).find()) {
					return name.trim();
				} else {
					System.err.println("Tên đoàn hơn 2 ký tự chỉ có chữ, số và khoảng trắng!!");
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập tên đoàn " + e);
			}
		} while (true);
	}

	/**
	 * Hàm nhập Tên khách hàng đã tồn tại
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputTenKhachHang(Connection conn) {
		Pattern regex = Pattern.compile(REGEX_NAME);
		do {
			try {
				System.out.println("Nhập tên Khách hàng: ");
				String name = sc.nextLine();
				if (!regex.matcher(name).find()) {
					System.err.println("Tên khách hàng hơn 2 ký tự chỉ có chữ, khoảng trắng!!");

				} else if (!CheckDataModel.checkTenKhachHang(conn, name)) {
					System.err.println("Không tồn tại khách hàng này");
				} else {
					return name.trim();
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập tên đoàn " + e);
			}
		} while (true);
	}

	/**
	 * Hàm nhập CMND đã tồn tại
	 * 
	 * @param conn
	 * @return
	 */
	public static String inputCMND(Connection conn) {
		Pattern regex = Pattern.compile(REGEX_CMND);
		do {
			try {
				System.out.println("Nhập CMND khách: ");
				String cmnd = sc.nextLine();
				if (!regex.matcher(cmnd).find()) {
					System.err.println("CMND bắt đầu là 02 và có 12 số!!");
				} else if (!CheckDataModel.checkCMND(conn, cmnd)) {
					System.err.println("Không tồn tại CMND này");
				} else {
					return cmnd.trim();
				}
			} catch (Exception e) {
				System.err.println("Lỗi nhập tên đoàn " + e);
			}
		} while (true);
	}

}
