package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class UpdateProductModel {

	public static void updateByName(Connection conn, String name, int soLuongDaBan, int soLuongConLai) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.product SET quality=?, sell=? WHERE name = ?");

			stmt.setInt(1, soLuongConLai);
			stmt.setInt(2, soLuongDaBan);
			stmt.setString(3, name);

			stmt.executeUpdate();
			System.out.println("Update thanh cong!!!");
			System.out.println("====================");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
