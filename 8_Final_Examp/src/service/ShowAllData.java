package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Apartment;
import model.House;
import model.LowCostHouse;
import model.LuxuryHouse;

public class ShowAllData {
	public static ArrayList<House> getData() {
		ArrayList<House> arrStu = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ultil.DButil.connectDB();

			stmt = conn.prepareStatement("SELECT * FROM dbo.House");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				if (rs.getString("Htype").equals("1")) {
					House apart = new LuxuryHouse();
					apart.setType(rs.getString("Htype"));
					apart.setHouseID(rs.getString("houseID"));
					apart.setSquare(rs.getString("Hsquare"));
					apart.setDirection(rs.getString("Direction"));

					apart.setStartDate(rs.getString("startDate"));

					apart.setCompletionDate(rs.getString("completionDate"));

					apart.setRightCertificate(rs.getString("rightcertificate"));
					apart.setPrice(rs.getFloat("price"));
					((LuxuryHouse) apart).setProjectName(rs.getString("projectname"));
					((LuxuryHouse) apart).setInvestor(rs.getString("investor"));
					((LuxuryHouse) apart).setView(rs.getString("Hview"));
					arrStu.add(apart);
				}
				if (rs.getString("Htype").equals("2")) {
					House apart = new LowCostHouse();
					apart.setType(rs.getString("Htype"));
					apart.setHouseID(rs.getString("houseID"));
					apart.setSquare(rs.getString("Hsquare"));
					apart.setDirection(rs.getString("Direction"));

					apart.setStartDate(rs.getString("startDate"));

					apart.setCompletionDate(rs.getString("completionDate"));

					apart.setRightCertificate(rs.getString("rightcertificate"));
					apart.setPrice(rs.getFloat("price"));
					((LowCostHouse) apart).setTransferYear(rs.getString("TransferYear"));
					arrStu.add(apart);
				}
				if (rs.getString("Htype").equals("3")) {
					House apart = new Apartment();
					apart.setType(rs.getString("Htype"));
					apart.setHouseID(rs.getString("houseID"));
					apart.setSquare(rs.getString("Hsquare"));
					apart.setDirection(rs.getString("Direction"));

					apart.setStartDate(rs.getString("startDate"));

					apart.setCompletionDate(rs.getString("completionDate"));

					apart.setRightCertificate(rs.getString("rightcertificate"));
					apart.setPrice(rs.getFloat("price"));
					((Apartment) apart).setFloor(rs.getString("Hfloor"));
					((Apartment) apart).setView(rs.getString("Hview"));
					arrStu.add(apart);
				}

			}
			return arrStu;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrStu;
		} finally {
			ultil.DButil.closeState(stmt);
			ultil.DButil.close(conn);
		}
	}
}
