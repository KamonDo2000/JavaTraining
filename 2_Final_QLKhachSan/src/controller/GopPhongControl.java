package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import common.ChangeStatusPhongControl;
import common.ChangeStatusPhongModel;
import common.GenerateIDControl;
import model.LichSuDatPhong;
import model.Phong;
import services.CheckDataModel;
import services.ChuyenPhongModel;
import services.GetDataModel;
import services.GopPhongModel;
import view.InputDataView;

public class GopPhongControl {

	/**
	 * Gộp hết tất cả các thành viên trong đoàn đó vào một phòng nếu có một phòng đủ
	 * sức chứa
	 * 
	 * @param conn
	 */
	public static void gopPhong(Connection conn) {
		System.out.println("\n===============Chức năng gộp phòng cho khách===============");
		if (!CheckDataModel.checkDatPhongEmpty(conn)) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		String cmnd = InputDataView.inputCMND(conn);
		String nameKH = GetDataModel.getNameByCMND(conn, cmnd);
		System.out.println("Khách hàng: " + nameKH);
		String iDCTDP = ChuyenPhongModel.checkKHDatPhong(conn, nameKH, cmnd);
		List<LichSuDatPhong> khachHangArr = GopPhongModel.getListMaKHinGroup(conn, iDCTDP);
		String idPhongNew;

		if (iDCTDP == null) {
			System.out.println("\nKhách hàng chưa ở phòng nào, vui lòng xếp phòng trước và thử lại sau!!!");
			return;
		}
		int tvDoan = GopPhongModel.getThanhVienTrongGroup(conn, iDCTDP);
		List<Phong> phongArr = GopPhongModel.getPhongTrongforGroup(conn, tvDoan);

		System.out.println("Đoàn " + iDCTDP + " của Khách hàng " + nameKH + " có tổng cộng " + tvDoan + " thành viên.");

		if (phongArr.isEmpty()) {
			System.out.println("Hiện không có Phòng nào đủ để gộp phòng cho khách hàng: " + nameKH);
			return;
		}
		for (Phong val : phongArr) {
			System.out.print("\t ID: " + val.getiDPhong());
			System.out.print("\t|| Sức chứa phòng: " + val.getSoNguoiToiDa());
			System.out.println("\t|| Giá: " + val.getGiaPhong());
		}

		boolean check = true;
		do {
			idPhongNew = InputDataView.inputIDPhong();
			for (Phong val : phongArr) {
				if (idPhongNew.equalsIgnoreCase(val.getiDPhong())) {
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("\nKhông có phòng nhập vào trong danh sách phòng chuyển!!");
				System.out.println("Yêu cầu nhập lại.\n");
			}
		} while (check);

		// Cập nhật lại trạng thái phòng cũ là chuyển phòng
		for (LichSuDatPhong val : khachHangArr) {
			ChuyenPhongModel.updateLSDP(conn, val.getiDKhachHang(), iDCTDP);
		}

		// Tạo LSDP mới

		LocalDate ngayKT = GetDataModel.getCTDPByID(conn, iDCTDP).getCheckOut();

		String isCaptain = "Co";
		for (LichSuDatPhong val : khachHangArr) {
			String idDP = GenerateIDControl.generateID(conn);
			ChuyenPhongModel.createLSDP(conn, idDP, isCaptain, ngayKT, val.getiDKhachHang(), iDCTDP, idPhongNew);
			isCaptain = "Khong";
		}

		ChangeStatusPhongModel.updateTrangThaiPhong(conn, idPhongNew, "Thue");
		ChangeStatusPhongControl.changeStatusPhongTrong(conn);

		System.out.println("Cập nhật thành công Đoàn khách hàng " + iDCTDP + " sang phòng " + idPhongNew);
	}
}
