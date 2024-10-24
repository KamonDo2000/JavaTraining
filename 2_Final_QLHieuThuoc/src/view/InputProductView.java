package view;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.CheckProductModel;

public class InputProductView {
	private static Scanner sc = new Scanner(System.in);

	private static final String REGEX_ID = "^[a-zA-Z0-9]{5}$";
	private static final String REGEX_NAME = "^.{6,20}$";

	public static String inputID(Connection conn) {
		Pattern rgID = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập ID: ");
				String id = sc.nextLine();
				if (!rgID.matcher(id).find()) {
					System.out.println("ID có 5 ký tự chu va so!!");
				}else if (CheckProductModel.checkID(conn, id)) {
					System.out.println("Đã có San Pham ID này");}
				else {
					return id;
				}
			} catch (Exception e) {
				System.out.println("ID có 5 ký tự chu va so!!");
			}
		} while (true);
	}

	public static String inputName() {
		Pattern rgTitle = Pattern.compile(REGEX_NAME);
		do {
			try {
				System.out.println("Input Ten san pham: ");
				String title = sc.nextLine();
				if (rgTitle.matcher(title).find()) {
					return title.trim();
				} else {
					System.out.println("Tên ít nhất 6 ký tự nhieu nhat 20 ky tu!!");
				}
			} catch (Exception e) {
				System.out.println("Ít nhất 6 ký tự!!");
			}
		} while (true);
	}

	public static int inputSoLuongNhapVao() {
		do {
			try {
				System.out.println("Nhập So luong nhap vao SP: ");
				String quality = sc.nextLine();
				if (Integer.parseInt(quality) > 0 && Integer.parseInt(quality) < 10000) {
					return Integer.parseInt(quality);
				} else {
					System.out.println("So luong nhap vao >0");
				}

			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

	public static int inputSoLuongDaBan() {
		do {
			try {
				System.out.println("Nhập So SP ban ra: ");
				String sell = sc.nextLine();
				if (Integer.parseInt(sell) > 0 && Integer.parseInt(sell) < 10000) {
					return Integer.parseInt(sell);
				} else {
					System.out.println("So luong ban ra >0");
				}

			} catch (Exception e) {
				System.out.println("phải là một số!!");
			}
		} while (true);
	}

}
