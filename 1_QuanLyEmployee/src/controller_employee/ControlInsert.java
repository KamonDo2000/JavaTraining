package controller_employee;

import java.sql.Connection;

import modelemployee.Employee;
import modelemployee.model_Insert;
import viewemployee.view_InputData;

public class ControlInsert {
	public static void insert(Connection conn) {

		Employee employee = new Employee();

		employee.setId(view_InputData.inputID(conn));
		employee.setName(view_InputData.inputName());
		employee.setAge(view_InputData.inputAge());
		employee.setAddress(view_InputData.inputAddress());
		employee.setSalary(view_InputData.inputSalary());
		employee.setSumTimeWork(view_InputData.inputSumTimeWork());

		model_Insert.insert(conn, employee);
	}

}
