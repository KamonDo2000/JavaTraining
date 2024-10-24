package view;

import java.util.Scanner;

public class InputSV {
	static Scanner sc = new Scanner(System.in);

	private static final String REGEX_MSSV = "^[a-zA-Z 0-9]{3,6}$";
	private static final String REGEX_HOVATEN = "^[a-z A-Z]{3,50}$";
	private static final String REGEX_NAMSINH = "^\\d{4}$";

	public static String mssv() {
		String mssv;
		do {
			System.out.print("Nhap MS sv: ");
			mssv = sc.nextLine();
		} while (!mssv.matches(REGEX_MSSV));
		return mssv;
	}

	public static String hoVaTen() {
		String hoVaTen;
		do {
			System.out.print("Nhap ho Ten sv: ");
			hoVaTen = sc.nextLine();
		} while (!hoVaTen.matches(REGEX_HOVATEN));
		return hoVaTen;
	}

	public static int namSinh() {
		String namSinh;
		do {
			System.out.print("Nhap Nam sinh: ");
			namSinh = sc.nextLine();
		} while (!namSinh.matches(REGEX_NAMSINH));
		return Integer.parseInt(namSinh);
	}

	public static float diemSo() {
		float diemSo;
		do {
			try {
				System.out.print("Nhap diem so: ");
				diemSo = Float.parseFloat(sc.nextLine());
				break;
			} catch (Exception e) {
				continue;
			}
		} while (true);
		return diemSo;
	}
}
