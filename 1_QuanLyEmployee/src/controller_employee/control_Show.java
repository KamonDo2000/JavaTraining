package controller_employee;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import modelemployee.Employee;
import modelemployee.model_GetEmployee;
import viewemployee.view_Employee;

public class control_Show {
	static Scanner sc = new Scanner(System.in);

	public static void showAll(Connection conn) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = model_GetEmployee.getAllEmployee(conn);
		view_Employee.viewAll(employees);
	}

	public static void showByName(Connection conn) {
		System.out.print("Nhập Tên muốn tìm kiếm:  ");
		String name = sc.nextLine();
		
		ArrayList<Employee> employee = new ArrayList<Employee>();
		employee = model_GetEmployee.getEmployeeByName(conn, name);
		view_Employee.viewAll(employee);
	}

}
