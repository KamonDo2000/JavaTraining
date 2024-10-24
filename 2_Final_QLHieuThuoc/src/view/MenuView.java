package view;

import java.util.Scanner;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {

		do {
			try {
				System.out.println("\n===========Menu==========");
				System.out.println("0. Để thoát.");
				System.out.println("1. Thêm thông tin sản phẩm vào chương trình.");
				System.out.println("2. Hiển thị danh sách toàn bộ sản phẩm hiện có .");
				System.out.println("3. Cập nhật Số lượng đã bán của một sản phẩm .");
				System.out.println("4. Xóa những sản phẩm đã quá hạn sử dụng.");
				System.out.println("5. sắp xếp danh sách sản phẩm theo Số lượng đã bán giảm dần .");

				System.out.print("Nhập lựa chọn: ");
				return Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}
}
