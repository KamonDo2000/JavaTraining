package common;

import java.sql.Connection;

public class GenerateIDControl {
	/**
	 * Hàm trả về LSDP ID hợp lệ tiếp theo để add
	 * 
	 * @param conn
	 * @return
	 */
	public static String generateID(Connection conn) {
		// "%1$" đối số thứ 1 độ lớn 3 và định dạng của đối số là chuỗi
		String iDLSDP = GenerateIDmodel.getIDDatPhongforGroup(conn);
		if (iDLSDP == null) {
			return "LSDP001";
		} else {
			iDLSDP = iDLSDP.substring(4);
		}
		int intID = Integer.parseInt(iDLSDP) + 1;
		String iDLSDPNew = "";
		if (intID < 999) {
			iDLSDPNew = String.format("%1$" + 3 + "s", String.valueOf(intID)).replace(' ', '0');
		} else {
			System.out.println("Lịch sử DP đã đầy!!");
		}
		return "LSDP" + iDLSDPNew;
	}

	/**
	 * Hàm trả về DP ID hợp lệ tiếp theo để add
	 * 
	 * @param conn
	 * @return
	 */
	public static String generateIDCTDP(Connection conn) {
		// "%1$" đối số thứ 1 độ lớn 3 và định dạng của đối số là chuỗi
		String idDP = GenerateIDmodel.getIDforCTDP(conn);
		if (idDP == null) {
			return "DP00001";
		} else {
			idDP = idDP.substring(2);
		}
		int intID = Integer.parseInt(idDP) + 1;
		String idDPNew = "";
		if (intID < 99999) {
			idDPNew = String.format("%1$" + 5 + "s", String.valueOf(intID)).replace(' ', '0');
		} else {
			System.out.println("Đặt Phòng đã đầy!!");
		}
		return "DP" + idDPNew;
	}

}
