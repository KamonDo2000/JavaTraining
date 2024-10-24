package controller;

import java.sql.Connection;
import java.time.LocalDate;

import common.GenerateIDControl;
import model.ChiTietDatPhong;
import services.InsertDataModel;
import view.InputDataView;
import view.InputDateView;

public class InsertDataControl {

	/**
	 * Thêm đặt phòng trước Khi thêm vào DB Nhập ID đoàn Nhập Tên đoàn Nhập ngày
	 * checkIn, checkOut
	 * 
	 * @param Connection conn
	 */
	public static void insertCTDP(Connection conn) {
		System.out.println("===============Chức năng thêm 1 đặt phòng===============");
		ChiTietDatPhong ctdp = new ChiTietDatPhong();

		String idDP = GenerateIDControl.generateIDCTDP(conn);
		ctdp.setiDChiTietDP(idDP);
		ctdp.setTenDoan(InputDataView.inputTenDoan());

		
		do {
			System.out.println("Nhập ngày đoàn sẽ CheckIn: ");
			ctdp.setCheckIn(InputDateView.inputNgay());
			if (ctdp.getCheckIn().isBefore(LocalDate.now())) {
				System.err.println("\nNgày Checkin không thể trước ngày hiện tại!!\n");
			}
		} while (ctdp.getCheckIn().isBefore(LocalDate.now()));

		do {
			System.out.println("Nhập ngày đoàn sẽ CheckOut: ");
			ctdp.setCheckOut(InputDateView.inputNgay());
			if (ctdp.getCheckIn().isAfter(ctdp.getCheckOut())) {
				System.err.println("\nNgày Checkin không thể sau ngày CheckOut!!\n");
			}
		} while (ctdp.getCheckIn().isAfter(ctdp.getCheckOut()));

		InsertDataModel.insertDatPhong(conn, ctdp);
	}

}
