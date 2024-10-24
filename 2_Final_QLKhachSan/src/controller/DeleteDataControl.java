package controller;

import java.sql.Connection;
import java.util.List;

import model.ChiTietDatPhong;
import services.DeleteDataModel;
import view.InputDataView;

public class DeleteDataControl {

	/**
	 * Xóa một Chi Tiết Đặt Phòng chưa bắt đầu hoặc đã cũ.
	 * 
	 * @param Connection conn
	 */
	public static void deleteCTDP(Connection conn) {
		System.out.println("\n===============Chức năng Xóa 1 đặt phòng===============");
		List<ChiTietDatPhong> ctdpArray = GetDataControl.getCTDPDelete(conn);
		if (ctdpArray.isEmpty()) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		System.out.println("\n===========================");
		String id = "";
		boolean ch = true;
		do {
			id = InputDataView.inputIDDelete(conn);
			if (id.equalsIgnoreCase("quit")) {
				System.out.println("Không tồn tại ID đặt phòng này");
				return;
			}
			for (ChiTietDatPhong val : ctdpArray) {
				if (id.equalsIgnoreCase(val.getiDChiTietDP())) {
					ch = false;
				}
			}
			if (ch) {
				System.out.println("Đoàn đang ở Khách sạn, Không thể Xóa thông tin bây giờ!!");
			}
		} while (ch);

		DeleteDataModel.deleteCTDP(conn, id);
	}

}
