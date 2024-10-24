package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Apartment;
import model.House;
import model.LowCostHouse;
import model.LuxuryHouse;

public class InsertData {
	public static void insertData(List<House> listHouse) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String stateString = "INSERT INTO dbo.House "
				+ "(Htype,houseID,Hsquare,Direction,startDate,completionDate,rightcertificate,price,projectname,investor,Hfloor,Hview,TransferYear)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ultil.DButil.connectDB();

			for (House house : listHouse) {
				stmt = conn.prepareStatement(stateString);
				stmt.setString(1, house.getType());
				stmt.setString(2, house.getHouseID());
				stmt.setString(3, house.getSquare());
				stmt.setString(4, house.getDirection());
				stmt.setString(5, house.getStartDate());
				stmt.setString(6, house.getCompletionDate());
				stmt.setString(7, house.getRightCertificate());
				stmt.setFloat(8, house.getPrice());
				stmt.setString(9, null);
				stmt.setString(10, null);
				stmt.setString(11, null);
				stmt.setString(12, null);
				stmt.setString(13, null);
				if (house instanceof LuxuryHouse) {
					stmt.setString(9, ((LuxuryHouse) house).getProjectName());
					stmt.setString(10, ((LuxuryHouse) house).getInvestor());
					stmt.setString(12, ((LuxuryHouse) house).getView());
				} else if (house instanceof Apartment) {
					stmt.setString(11, ((Apartment) house).getFloor());
					stmt.setString(12, ((Apartment) house).getView());
				} else {
					stmt.setString(13, ((LowCostHouse) house).getTransferYear());
				}
				stmt.executeUpdate();
			}

			System.out.println("Add success!!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			ultil.DButil.closeState(stmt);
			ultil.DButil.close(conn);
		}
	}
}
