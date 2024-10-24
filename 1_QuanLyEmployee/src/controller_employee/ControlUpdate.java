package controller_employee;

import java.sql.Connection;
import java.util.Scanner;

import modelemployee.Employee;
import modelemployee.model_CheckID;
import modelemployee.ModelUpdate;
import viewemployee.view_InputData;

public class ControlUpdate {
	static Scanner sc = new Scanner(System.in);

	public static void updateByID(Connection conn) {
		try {
			System.out.print("Nhập ID nhân viên muốn cập nhật:  ");
			long id = Long.parseLong(sc.nextLine());

			if (model_CheckID.checkID(conn, id)) {
				Employee employee = new Employee();

				employee.setId(id);
				employee.setName(view_InputData.inputName());
				employee.setAge(view_InputData.inputAge());
				employee.setAddress(view_InputData.inputAddress());
				employee.setSalary(view_InputData.inputSalary());
				employee.setSumTimeWork(view_InputData.inputSumTimeWork());

				boolean update = ModelUpdate.update(conn, employee);
				if (update) {
					System.out.println("Chỉnh sửa thành công");
				}
			} else {
				System.out.println("chưa có nhân viên này trong csdl!!");
			}
		} catch (Exception e) {
			System.out.println("Không có nhân viên này!!");
		}

	}
}
