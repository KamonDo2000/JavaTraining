package viewemployee;

import java.sql.Connection;
import java.util.Scanner;

import controller_employee.ControlUpdate;
import controller_employee.DButil;
import controller_employee.ControlDelete;
import controller_employee.ControlInsert;
import controller_employee.control_Show;

public class Index {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Tao ket noi
			conn = DButil.connectDB();

			do {
				int pick = menu();
				switch (pick) {
				case 0:
					return;
				case 1:
					System.out.println("\n");
					ControlInsert.insert(conn);
					continue;
				case 2:
					System.out.println("\n");
					control_Show.showAll(conn);
					continue;
				case 3:
					System.out.println("\n");
					control_Show.showByName(conn);
					continue;
				case 4:
					System.out.println("\n");
					ControlDelete.deleteByID(conn);
					continue;
				case 5:
					System.out.println("\n");
					ControlUpdate.updateByID(conn);
					continue;
				default:
				}
			} while (true);

		} finally {
			DButil.close(conn);
		}
	}

	private static Scanner sc = new Scanner(System.in);

	private static int menu() {

		do {
			try {
				System.out.println("\n\n===========Menu==========");
				System.err.println("0. Để thoát.");
				System.err.println("1. Nhập thêm thông tin vào DataBase.");
				System.err.println("2. In ra tất cả các thông tin của nhân viên.");
				System.err.println("3. Tìm kiếm thông tin Employee theo tên.");
				System.err.println("4. Xóa thông tin Employee.");
				System.err.println("5. Update thông tin Employee.");

				System.err.print("Nhập lựa chọn: ");
				int pick = Integer.parseInt(sc.nextLine());

				if (pick == 0 || pick == 1 || pick == 2 || pick == 3 || pick == 4 || pick == 5) {
					return pick;
				}
				System.err.println("chỉ có các lựa chọn 0, 1, 2, 3, 4, 5!!!");
			} catch (Exception e) {
				System.err.println("chỉ có các lựa chọn 0, 1, 2, 3, 4, 5!!!");
			}
		} while (true);
	}

}
