package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.ChiTietDatPhong;
import services.GetDataModel;
import services.UpdateDataModel;
import view.InputDataView;
import view.InputDateView;
import view.ShowDataView;

public class UpdateDateControl {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Cập nhật đặt phòng theo tên hoặc ngày bắt đầu hoặc ngày kết thúc. đối với
	 * khách hàng chưa đến ở
	 * 
	 * @param Connection conn
	 */
	public static void updateCTDP(Connection conn) {
		System.out.println("\n===============Chức năng chỉnh sửa 1 đặt phòng===============");
		List<ChiTietDatPhong> ctdpArray = GetDataControl.getCTDPUpdate(conn);
		if (ctdpArray.isEmpty()) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		String id = "";
		boolean ch = true;
		do {
			id = InputDataView.inputIDUpdate(conn);
			for (ChiTietDatPhong val : ctdpArray) {
				if (id.equalsIgnoreCase(val.getiDChiTietDP())) {
					ch = false;
				}
			}
			if (ch) {
				System.out.println("Đoàn đã đến ở Khách Sạn Không thể chỉnh sửa thông tin!!");
			}
		} while (ch);
		System.err.println("\n===========================");
		ChiTietDatPhong ctdp = GetDataModel.getCTDPByID(conn, id);
		do {
			try {
				System.out.print("\t");
				ShowDataView.showDataCTDP(ctdp);
				System.out.print("Nhập 0 hoàn tất.");
				System.out.print("\t|| 1 sửa Tên Đoàn.");
				System.out.print("\t|| 2 sửa CheckIn.");
				System.out.print("\t|| 3 sửa CheckOut.");
				System.out.println("\t|| 4 sửa cả 3 !!");
				System.out.print("Nhập: ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 0:
					UpdateDataModel.updateCTDP(conn, ctdp);
					return;
				case 1:
					ctdp.setTenDoan(InputDataView.inputTenDoan());
					continue;
				case 2:
					do {
						System.out.println("Nhập ngày đoàn sẽ CheckIn: ");
						ctdp.setCheckIn(InputDateView.inputNgay());
						if (ctdp.getCheckIn().isAfter(ctdp.getCheckOut())
								|| ctdp.getCheckIn().isBefore(LocalDate.now())) {
							System.err.println("\nNgày CheckIn phải sau ngày hiện tại và trước ngày checkout !!\n");
						}
					} while (ctdp.getCheckIn().isAfter(ctdp.getCheckOut())
							|| ctdp.getCheckIn().isBefore(LocalDate.now()));
					continue;
				case 3:
					do {
						System.out.println("Nhập ngày đoàn sẽ CheckOut: ");
						ctdp.setCheckOut(InputDateView.inputNgay());
						if (ctdp.getCheckIn().isAfter(ctdp.getCheckOut())) {
							System.err.println("\nNgày CheckOut không thể trước ngày CheckIn!!\n");
						}
					} while (ctdp.getCheckIn().isAfter(ctdp.getCheckOut()));
					continue;
				case 4:
					ctdp.setTenDoan(InputDataView.inputTenDoan());

					do {
						System.out.println("Nhập ngày đoàn sẽ CheckIn: ");
						ctdp.setCheckIn(InputDateView.inputNgay());
						if (ctdp.getCheckIn().isBefore(LocalDate.now())) {
							System.err.println("\nNgày CheckIn phải sau ngày hiện tại !!\n");
						}
					} while (ctdp.getCheckIn().isBefore(LocalDate.now()));

					do {
						System.out.println("Nhập ngày đoàn sẽ CheckOut: ");
						ctdp.setCheckOut(InputDateView.inputNgay());
						if (ctdp.getCheckIn().isAfter(ctdp.getCheckOut())) {
							System.err.println("\nNgày CheckOut không thể trước ngày CheckIn!!\n");
						}
					} while (ctdp.getCheckIn().isAfter(ctdp.getCheckOut()));
					continue;
				default:
					System.err.println("\nKhông có lựa chọn này!!!");
				}

			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}

}
