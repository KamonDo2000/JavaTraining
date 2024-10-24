package modelemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class model_GetEmployee {

	public static ArrayList<Employee> getAllEmployee(Connection conn) {
		ArrayList<Employee> arrEmployees = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM dbo.Employee";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getLong("id"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setAddress(result.getString("diachi"));
				employee.setSalary(result.getDouble("salary"));
				employee.setSumTimeWork(result.getInt("sumTimeWork"));
				arrEmployees.add(employee);
			}

			return arrEmployees;
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
			return arrEmployees;
		}
	}

	public static ArrayList<Employee> getEmployeeByName(Connection conn, String name) {
		ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
		try {
			String sql = "SELECT * FROM dbo.Employee WHERE name LIKE ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + name);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getLong("id"));
				employee.setName(result.getString("name"));
				employee.setAge(result.getInt("age"));
				employee.setAddress(result.getString("diachi"));
				employee.setSalary(result.getDouble("salary"));
				employee.setSumTimeWork(result.getInt("sumTimeWork"));
				arrEmployee.add(employee);
			}
			return arrEmployee;
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
			return arrEmployee;
		}
	}

}
