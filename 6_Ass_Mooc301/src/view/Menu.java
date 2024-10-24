package view;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("==================================");
		System.out.println("0. Exits");
		System.out.println("1.tạo mảng 10 Person các loại.");
		System.out.println("2.Xem danh sách sinh viên");
		System.out.println("3.cập nhật thông tin sinh viên");
		System.out.println("4.hiển thị giáo viên lương cao hơn 1000$.");
		System.out.println("5.hiển thị sinh viên và điểm cuối cùng của họ, điểm cuối cùng >= 6");
		int pick = -1;

		do {
			try {
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 0 || pick > 5) {
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
