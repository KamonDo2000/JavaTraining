package view;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("==================================");
		System.out.println("0. Exits");
		System.out.println("1.tạo Course.");
		System.out.println("2.Show full course.");
		System.out.println("3.Tìm kiếm khóa học theo một trong các thuộc tính");
		System.out.println("4.Hiển thị tất cả các khóa học được gắn cờ là mandatory");
		int pick = -1;

		do {
			try {
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 0 || pick > 4) {
					System.err.println("Khong co lua chon!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.err.println("Nhap vao sai!");
				continue;
			}
		} while (true);

		return pick;
	}
}
