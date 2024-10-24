package common;

import java.sql.Connection;
import java.util.List;

import model.Phong;

public class ChangeStatusPhongControl {

	/**
	 * Thay đổi hết các phòng không có người ở về trạng thái trống
	 * 
	 * @param conn
	 */
	public static void changeStatusPhongTrong(Connection conn) {
		List<Phong> phongArr = ChangeStatusPhongModel.getAllIDPhong(conn);
		for (Phong val : phongArr) {
			if (ChangeStatusPhongModel.checkNguoiTrongPhong(conn, val.getiDPhong()) == 0) {
				ChangeStatusPhongModel.updateTrangThaiPhong(conn, val.getiDPhong(), "Trong");
			}
		}
	}

}
