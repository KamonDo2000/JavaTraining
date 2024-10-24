package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.ChangeStatusPhongControl;
import common.ChangeStatusPhongModel;
import common.GenerateIDControl;
import model.LichSuDatPhong;
import model.Phong;
import services.CheckDataModel;
import services.ChuyenPhongModel;
import services.GetDataModel;
import view.InputDataView;

public class ChuyenPhongControl {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Thực hiện chuyển phòng cho Khách hàng nếu Khách đã ở một phòng nào đó trong
	 * Khách sạn
	 * 
	 * @param conn
	 */
	public static void chuyenPhong(Connection conn) {
		System.out.println("\n===============Chức năng chuyển phòng cho khách===============");
		if (!CheckDataModel.checkDatPhongEmpty(conn)) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		String cmnd = InputDataView.inputCMND(conn);
		String nameKH = GetDataModel.getNameByCMND(conn, cmnd);
		System.out.println("Khách hàng: " + nameKH);
		String iDCTDP = ChuyenPhongModel.checkKHDatPhong(conn, nameKH, cmnd);

		LichSuDatPhong lSDP = ChuyenPhongModel.getIDKHbyName(conn, nameKH, iDCTDP);

		String idPhong = lSDP.getiDPhong();
		String idKH = lSDP.getiDKhachHang();
		LocalDate ngayKT = lSDP.getNgayKetThuc();
//Lấy thông tin khách hàng và kiểm tra khách có đang ở không, có ở thì mới chuyển phòng được.
		if (iDCTDP == null) {
			System.out.println("\nKhách hàng chưa ở phòng nào, vui lòng xếp phòng trước và thử lại sau!!!");
			return;
		}
//Hiển thị Menu cho khách chọn, có chuyển qua phòng chung đoàn và tạo phòng mới chuyển qua.
		System.out.println("Khách hàng muốn chuyển qua: ");
		List<Phong> phongArr = new ArrayList<>();
		String isCaptain = "Khong";
		String idPhongNew;
		boolean check = true;
		do {
			try {
				System.out.println("\t 1. Phòng chung đoàn.");
				System.out.println("\t 2. Phòng còn trống của KS.");
				System.out.print("Nhập lựa chọn: ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					phongArr = ChuyenPhongModel.getPhongChungGroup(conn, iDCTDP, idPhong);
					if (phongArr.isEmpty()) {
						System.out.println("\nHiện đoàn này không có phòng có thể chuyển vào!\n");
						break;
					} else {
						isCaptain = "Khong";
						for (Phong val : phongArr) {
							System.out.print("\t ID: " + val.getiDPhong());
							System.out.print("\t|| Số người trong phòng: " + val.getSoNguoiTrongPhong());
							System.out.print("\t|| Sức chứa phòng: " + val.getSoNguoiToiDa());
							System.out.println("\t|| Giá: " + val.getGiaPhong());
						}
						check = false;
					}
					break;
				case 2:
					phongArr = ChuyenPhongModel.getPhongTrong(conn);
					if (phongArr.isEmpty()) {
						System.out.println("\nĐã hết phòng trống!!!\n");
						return;
					} else {
						isCaptain = "Co";
						for (Phong val : phongArr) {
							System.out.print("\t ID: " + val.getiDPhong());
							System.out.print("\t|| Sức chứa phòng: " + val.getSoNguoiToiDa());
							System.out.println("\t|| Giá: " + val.getGiaPhong());
						}
						check = false;
					}
					break;
				default:
					System.err.println("\nKhông có lựa chọn này!!!");
				}
			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (check);
//Thực hiện nhập phòng có trong danh sách phòng có thể chuyển
		check = true;
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

//Thực hiện chuyển phòng và cập nhật lại phòng cũ.
		// General ID
		String idDP = GenerateIDControl.generateID(conn);
		// cập nhật đơn dp
		ChuyenPhongModel.updateLSDP(conn, idKH, iDCTDP);
		ChuyenPhongModel.createLSDP(conn, idDP, isCaptain, ngayKT, idKH, iDCTDP, idPhongNew);
		// Cap nhật trặng thái phòng
		ChangeStatusPhongModel.updateTrangThaiPhong(conn, idPhongNew, "Thue");
		ChangeStatusPhongControl.changeStatusPhongTrong(conn);

		System.out.println("Cập nhật thành công khách hàng " + nameKH + " sang phòng " + idPhongNew);
	}

}
