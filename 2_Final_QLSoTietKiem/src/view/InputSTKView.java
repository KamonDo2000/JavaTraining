package view;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.CheckSTKModel;

public class InputSTKView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_ID = "^STK\\d{4}$";
	private static final String REGEX_HOTEN = "^[a-zA-Z ]{3,50}$";
	private static final String REGEX_CMND = "^\\d{5,9}$";
	private static final String REGEX_DIACHI = "^[a-zA-Z0-9 ]{3,50}$";
	private static final String REGEX_SODIENTHOAI = "^09\\d{8}$";
	private static final String REGEX_KYHAN = "^1|3|6|12$";

	private static final String REGEX_STATUS = "^[0-1]$";

	public static String inputMaSoTK(Connection conn) {
		Pattern rgID = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập Mã sổ tiết kiệm: ");
				String maSoTK = sc.nextLine();
				if (!rgID.matcher(maSoTK).find()) {
					System.out.println("có định dạng là STKxxxx xxxx là số !!");
				} else if (CheckSTKModel.checkSTK(conn, maSoTK)) {
					System.out.println("Đã có STK này");
				} else {
					return maSoTK.trim();
				}
			} catch (Exception e) {
				System.out.println("có định dạng là STKxxxx xxxx là số !!");
			}
		} while (true);
	}

	public static String inputMaSTKKhongCheck() {
		Pattern rgID = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập Mã sổ tiết kiệm: ");
				String maSoTK = sc.nextLine();
				if (!rgID.matcher(maSoTK).find()) {
					System.out.println("có định dạng là STKxxxx xxxx là số !!");
				} else {
					return maSoTK.trim();
				}
			} catch (Exception e) {
				System.out.println("có định dạng là STKxxxx xxxx là số !!");
			}
		} while (true);
	}

	public static String inputHoTen() {
		Pattern regex = Pattern.compile(REGEX_HOTEN);
		do {
			try {
				System.out.println("Input Ho va Ten : ");
				String hoTen = sc.nextLine();
				if (regex.matcher(hoTen).find()) {
					return hoTen.trim();
				} else {
					System.out.println("Tên ít nhất 3 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("Tên ít nhất 3 ký tự va chi co chu!!");
			}
		} while (true);
	}

	public static String inputCMND() {
		Pattern regex = Pattern.compile(REGEX_CMND);
		do {
			try {
				System.out.println("Input CMND: ");
				String cmnd = sc.nextLine();
				if (regex.matcher(cmnd).find()) {
					return cmnd.trim();
				} else {
					System.out.println("CMND 3-9 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("CMND 3-9 ký tự!!!");
			}
		} while (true);
	}

	public static String inputDiaChi() {
		Pattern regex = Pattern.compile(REGEX_DIACHI);
		do {
			try {
				System.out.println("Input Dia Chi: ");
				String diaChi = sc.nextLine();
				if (regex.matcher(diaChi).find()) {
					return diaChi.trim();
				} else {
					System.out.println("Dia chi co so va chu, 3 - 50 ky tu!!");
				}
			} catch (Exception e) {
				System.out.println("Dia chi co so va chu, 3 - 50 ky tu!!");
			}
		} while (true);
	}

	public static String inputSoDienThoai() {
		Pattern regex = Pattern.compile(REGEX_SODIENTHOAI);
		do {
			try {
				System.out.println("Input SDT: ");
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

	public static String inputKyHan() {
		Pattern regex = Pattern.compile(REGEX_KYHAN);
		do {
			try {
				System.out.println("Input Ky han: ");
				String kyHan = sc.nextLine();
				if (regex.matcher(kyHan).find()) {
					return kyHan.trim();
				} else {
					System.out.println("Kỳ hạn gửi tiết kiệm: 1 tháng/3 tháng/6 tháng/12 tháng");
				}
			} catch (Exception e) {
				System.out.println("Kỳ hạn gửi tiết kiệm: 1 tháng/3 tháng/6 tháng/12 tháng");
			}
		} while (true);
	}

	public static int inputPTTaiTuc() {
		do {
			Pattern rgStatus = Pattern.compile(REGEX_STATUS);
			try {
				System.out.println("Nhập tai tuc (0: Tự động tái tục|| 1: Không tự động tái tục): ");
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

	public static float inputSoTien() {
		do {
			try {
				System.out.println("Nhập Số tiền gửi tiết kiệm: ");
				String soTien = sc.nextLine();
				if (Float.parseFloat(soTien) > 10) {
					return Float.parseFloat(soTien);
				} else {
					System.out.println("Số tiền gửi tiết kiệm lớn hơn 10.00 USD !!");
				}

			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

}
