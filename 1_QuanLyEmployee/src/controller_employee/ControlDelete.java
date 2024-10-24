package controller_employee;

import java.sql.Connection;
import java.util.Scanner;

import modelemployee.model_CheckID;
import modelemployee.ModelDelete;

public class ControlDelete {
	static Scanner sc = new Scanner(System.in);

	public static void deleteByID(Connection conn) {
		try {
			System.out.print("Nhập ID nhân viên muốn xóa:  ");
			long id = Long.parseLong(sc.nextLine());

			if (model_CheckID.checkID(conn, id)) {
				boolean del = ModelDelete.delete(conn, id);
				if (del) {
					System.out.println("xóa thành công");
				}
			} else {
				System.out.println("Không có nhân viên này!!");
			}
		} catch (Exception e) {
			System.out.println("Không có nhân viên này!!");
		}

	}

}
