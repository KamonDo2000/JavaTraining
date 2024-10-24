package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import controller.DButil;
import model.Adult;
import model.Children;
import model.Person;
import model.Pregnant;

public class SQLService {
	static Connection conn = null;
	static PreparedStatement preparedStatement = null;

	private static final String QUERY_INSERT_DATA = "INSERT INTO dbo.PERSON (type,passengerID,name,birthDate,address,phone,testDate,flightDate,job,school,grade,gestationalAge,pretermBirth) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String QUERY_SELECT_DATA = "SELECT * FROM House";
	private static final String QUERY_UPDATE_ACTUAL = "UPDATE House SET ActualPrice = ? WHERE HouseID = ?";

	public static void insertData(List<Person> listData) {
		try {
			conn = DButil.connectDB();
			preparedStatement = conn.prepareStatement(QUERY_INSERT_DATA);
			conn.setAutoCommit(false);

			boolean isAddData = false;
			for (Person per : listData) {

				// Validate continue

				isAddData = true;
				preparedStatement.setInt(1, per.getType());
				preparedStatement.setString(2, per.getPassengerID());
				preparedStatement.setString(3, per.getName());
				preparedStatement.setString(4, per.getBirthDate());
				preparedStatement.setString(5, per.getAddress());
				preparedStatement.setString(6, per.getPhone());
				preparedStatement.setString(7, per.getTestDate());
				preparedStatement.setString(8, per.getFlightDate());
				preparedStatement.setString(9, null);
				preparedStatement.setString(10, null);
				preparedStatement.setString(11, null);
				preparedStatement.setString(12, null);
				preparedStatement.setString(13, null);
				if (per instanceof Adult) {
					preparedStatement.setString(9, ((Adult) per).getJob());
				}
				if (per instanceof Children) {
					preparedStatement.setString(10, ((Children) per).getSchool());
					preparedStatement.setString(11, ((Children) per).getGrade());
				}
				if (per instanceof Pregnant) {
					preparedStatement.setString(12, ((Pregnant) per).getGestationalAge());
					preparedStatement.setString(13, ((Pregnant) per).getPretermBirth());
				}
				preparedStatement.execute();
			}
			if (isAddData) {
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("Thêm dữ liệu thành công !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Thêm dữ liệu thất bại !!!");
		} finally {
			try {
				conn.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
