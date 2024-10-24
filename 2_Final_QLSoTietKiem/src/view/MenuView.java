package view;

import java.sql.Connection;
import java.util.Scanner;

import model.CheckSTKModel;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static int menu(Connection conn) {

		do {
			try {
				System.out.println("\n===========Menu==========");
				System.out.println("0. Để thoát.");
				System.out.println("1. Thêm thông tin sổ tiết kiệm.");
				System.out.println("2. Tìm kiếm sổ tiết kiệm theo khoảng thời gian.");
				System.out.println("3. Tìm kiếm sổ tiết kiệm theo kỳ hạn.");
				System.out.println("4. Cập nhật thông tin sổ tiết kiệm.");
				System.out.println("5. Sắp xếp sổ tiết kiệm theo số tiền gửi và ngày gửi tiết kiệm.");

				System.out.print("Nhập lựa chọn: ");
				int check = Integer.parseInt(sc.nextLine());

				if (CheckSTKModel.checkEmpty(conn) && (check == 2 || check == 3 || check == 4 || check == 5)) {
					System.out.println(
							"Hiện tại chưa có sổ tiết kiệm nào được nhập. Xin bạn hãy dùng chức năng này sau khi nhập sổ tiết kiệm");
					continue;
				}

				return check;

			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}
}
