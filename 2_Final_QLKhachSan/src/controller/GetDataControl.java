package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDatPhong;
import services.GetDataModel;
import view.InputDataView;
import view.ShowDataView;

public class GetDataControl {

	/**
	 * Nhập Tên Khách hàng và hiển thị thông tin theo tên
	 * 
	 * @param conn
	 */
	public static void getInforX(Connection conn) {
		System.out.println("\n===============Chức năng hiển thị thông tin lưu trú khách hàng===============");
		String xName = InputDataView.inputTenKhachHang(conn);

		GetDataModel.getInforByName(conn, xName);
	}

	/**
	 * Lấy danh sách CTDP và hiển thị tất cả
	 * 
	 * @param conn
	 */
	public static void getAllCTDP(Connection conn) {
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();

		ctdpArray = GetDataModel.getAllCTDP(conn);
		ShowDataView.showAllDataCTDP(ctdpArray);
	}

	/**
	 * Lấy danh sách CTDP Chưa đến ở và hiển thị
	 * 
	 * @param conn
	 */
	public static List<ChiTietDatPhong> getCTDPUpdate(Connection conn) {
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();

		ctdpArray = GetDataModel.getCTDPUpdate(conn);
		ShowDataView.showAllDataCTDP(ctdpArray);

		return ctdpArray;
	}

	/**
	 * Lấy danh sách CTDP không phải đang ở và hiển thị
	 * 
	 * @param conn
	 */
	public static List<ChiTietDatPhong> getCTDPDelete(Connection conn) {
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();

		ctdpArray = GetDataModel.getCTDPDelete(conn);
		ShowDataView.showAllDataCTDP(ctdpArray);

		return ctdpArray;
	}

}
