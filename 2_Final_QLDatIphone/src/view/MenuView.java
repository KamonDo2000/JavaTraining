package view;

import java.sql.Connection;
import java.util.Scanner;

import model.CheckDataModel;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu(Connection conn) {

		do {
			try {

				System.out.println("\nCác chức năng chính của chương trình");
				System.out.println("1. Thêm thông tin order");
				System.out.println("2. Tìm thông tin order theo ngày order");
				System.out.println("3. Hiển thị thông tin tất cả order của ngày hiện tại");
				System.out.println("4. Cập nhật đơn giá của tất cả order đối với mặt hàng Iphone 15");
				System.out.println("5. Sắp xếp thông tin order theo ngày order và mã order");
				System.out.println("6. Thoát khỏi chương trình");

				System.out.print("Nhập lựa chọn: ");
				int check = Integer.parseInt(sc.nextLine());

				if (CheckDataModel.checkEmpty(conn) && (check == 2 || check == 3 || check == 4 || check == 5)) {
					System.out
							.println("\nHiện tại chưa có order nào trong danh sách. Xin bạn vui lòng truy cập lại sau");
					continue;
				}

				return check;

			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}
}
