package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.ChangeStatusPhongModel;
import common.GenerateIDControl;
import model.ChiTietDatPhong;
import model.Phong;
import services.CheckDataModel;
import services.ChuyenPhongModel;
import services.GetDataModel;
import services.XepPhongModel;
import view.InputDataView;

public class XepPhongControl {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Xếp phòng cho khách hàng mới đến ở chưa có phòng
	 * 
	 * @param conn
	 */
	public static void xepPhongKhachX(Connection conn) {
		System.out.println("\n===============Chức năng xếp phòng cho khách===============");
		if (!CheckDataModel.checkDatPhongEmpty(conn)) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		String cmnd = InputDataView.inputCMND(conn);
		String nameKH = GetDataModel.getNameByCMND(conn, cmnd);
		System.out.println("Khách hàng: " + nameKH);
		String iDKH = XepPhongModel.getIDKhachHangByCMND(conn, cmnd);

		if (CheckDataModel.getKHDatPhongChua(conn, iDKH)) {
			System.out.println("\nKhách hàng này đã ở khách sạn, hãy xử dụng tính năng chuyển phòng!!!");
			return;
		}

		ChiTietDatPhong ctdp;
		do {
			String tenDoan = InputDataView.inputTenDoan();
			ctdp = XepPhongModel.getCTDPByTenDoan(conn, tenDoan);
			if (ctdp.getiDChiTietDP() == null) {
				System.out.println("\nKhông có tên đoàn này đăng ký, nhập lại!!");
			}
		} while (ctdp.getiDChiTietDP() == null);

		String iDCTDP = ctdp.getiDChiTietDP();

		// Thực hiện cho khách chọn phòng.
		System.out.println("Khách hàng muốn chuyển vào: ");
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
					phongArr = XepPhongModel.getPhongChungGroup(conn, iDCTDP);
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

		String idDP = GenerateIDControl.generateID(conn);

//		LocalDate ngayBD = ctdp.getCheckIn();
		LocalDate ngayKT = ctdp.getCheckOut();
		XepPhongModel.createLSDP(conn, idDP, isCaptain, ngayKT, iDKH, iDCTDP, idPhongNew);
		ChangeStatusPhongModel.updateTrangThaiPhong(conn, idPhongNew, "Thue");

		System.out.println("Thêm thành công khách hàng " + iDKH + " vào phòng " + idPhongNew);

	}

}
