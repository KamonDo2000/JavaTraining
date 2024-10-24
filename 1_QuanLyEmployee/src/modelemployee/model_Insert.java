package modelemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class model_Insert {
	public static void insert(Connection conn, Employee employee) {
		try {
			String sql = "INSERT INTO Employee VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setLong(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setInt(3, employee.getAge());
			stmt.setString(4, employee.getAddress());
			stmt.setDouble(5, employee.getSalary());
			stmt.setInt(6, employee.getSumTimeWork());

			int cnt = stmt.executeUpdate();
			System.out.println("Đã Thêm " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		}
	}
}
