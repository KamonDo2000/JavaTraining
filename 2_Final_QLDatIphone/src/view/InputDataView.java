package view;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.CheckDataModel;

public class InputDataView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_ID = "^\\d{10}$";
	private static final String REGEX_HOTEN = "^[a-zA-Z ]{3,50}$";
	private static final String REGEX_TENSP = "^[Ii][Pp][hH][oO][nN][eE][a-zA-Z0-9 ]{0,30}$";
	private static final String REGEX_SODIENTHOAI = "^09\\d{8}$";

	public static String inputMaOder(Connection conn) {
		Pattern regex = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập Mã Oder: ");
				String maOrder = sc.nextLine();
				if (!regex.matcher(maOrder).find()) {
					System.out.println("có định dạng là 10 chữ số !!");
				} else if (CheckDataModel.checkMaOder(conn, maOrder)) {
					System.out.println("Đã có Mã Oder này");
				} else {
					return maOrder.trim();
				}
			} catch (Exception e) {
				System.out.println("có định dạng là 10 chữ số !!");
			}
		} while (true);
	}

	public static String inputTenKhachHang() {
		Pattern regex = Pattern.compile(REGEX_HOTEN);
		do {
			try {
				System.out.println("Nhập Ho va Ten : ");
				String hoTen = sc.nextLine();
				if (regex.matcher(hoTen).find()) {
					return hoTen.trim();
				} else {
					System.out.println("Tên ít nhất 3 ký tự và chỉ có chữ!!");
				}
			} catch (Exception e) {
				System.out.println("Tên ít nhất 3 ký tự và chỉ có chữ!!");
			}
		} while (true);
	}

	public static String inputSoDienThoai() {
		Pattern regex = Pattern.compile(REGEX_SODIENTHOAI);
		do {
			try {
				System.out.println("Nhập SDT: ");
				String soDienThoai = sc.nextLine();
				if (regex.matcher(soDienThoai).find()) {
					return soDienThoai.trim();
				} else {
					System.out.println("có định dạng là 09xxxxxxxx x la so!!");
				}
			} catch (Exception e) {
				System.out.println("có định dạng là 09xxxxxxxx x la so!!");
			}
		} while (true);
	}

	public static String inputTenSanPham() {
		Pattern regex = Pattern.compile(REGEX_TENSP);
		do {
			try {
				System.out.println("Nhập Tên SP: ");
				String name = sc.nextLine();
				if (regex.matcher(name).find()) {
					return name.trim();
				} else {
					System.out.println("Sản phẩm chỉ có số và chữ, bắt đầu là IPhone, 3 - 10 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("Có lỗi xảy ra!!");
			}
		} while (true);
	}

	public static int inputSoLuong() {
		do {
			try {
				System.out.println("Nhập Số lượng: ");
				String soLuong = sc.nextLine();
				if (Integer.parseInt(soLuong) > 0) {
					return Integer.parseInt(soLuong);
				} else {
					System.out.println("Số lượng phải >0 !!");
				}
			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

	public static int inputDonGia() {
		do {
			try {
				System.out.println("Nhập Đơn Giá ");
				String gia = sc.nextLine();
				if (Integer.parseInt(gia) > 100) {
					return Integer.parseInt(gia);
				} else {
					System.out.println("Đơn giá lớn hơn 100 USD !!");
				}
			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

	public static int inputGiamGia() {
		do {
			try {
				System.out.println("Nhập số % giảm giá");
				String gia = sc.nextLine();
				if (Integer.parseInt(gia) > 0 && Integer.parseInt(gia) < 8) {
					return Integer.parseInt(gia);
				} else {
					return 0;
				}
			} catch (Exception e) {
				System.out.println("phải là một số nguyên từ 0-7!!");
			}
		} while (true);
	}

}
