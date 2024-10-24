package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import index.DButil;

public class SearchService {

	public static boolean searchByID(Connection conn, String id) {
		String stateString = "SELECT * FROM dbo.TAB_CANDIDATE WHERE candidateID = ?";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(stateString);
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			System.out.println("Co loi xay ra" + e);
			return false;
		} finally {
			DButil.closeState(stmt);
		}
	}
	
	public static boolean searchCertificateByID(Connection conn, String id) {
		String stateString = "SELECT * FROM dbo.TAB_CERTIFICATE WHERE certificatedID = ?";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(stateString);
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			System.out.println("Co loi xay ra" + e);
			return false;
		} finally {
			DButil.closeState(stmt);
		}
	}

}
