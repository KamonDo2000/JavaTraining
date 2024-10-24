package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import model.DichVu;
import model.LichSuDatPhong;
import services.CheckDataModel;
import services.GetDataModel;
import services.TinhTongTienModel;
import view.InputDataView;
import view.InputDateView;

public class TinhTongTienControl {

	/**
	 * Tính tổng bill của đoàn đó. Gồm tiền ở và tiền dùng dịch vụ
	 * 
	 * @param conn
	 */
	public static void tongTien(Connection conn) {
		System.out.println("\n===============Chức năng tính tổng Bill===============");
		if (!CheckDataModel.checkDatPhongEmpty(conn)) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}
		long tongTien;
		String tenDoan;
		LocalDate checkIn;
		do {
			tenDoan = InputDataView.inputTenDoan();
			System.out.println("Nhập ngày CheckIn: ");
			checkIn = InputDateView.inputNgay();

			if (!CheckDataModel.checkTenDoan(conn, tenDoan, checkIn)) {
				System.out.println("Thông tin đặt phòng chưa đúng, yêu cầu nhập lại!!\n");
			}
		} while (!CheckDataModel.checkTenDoan(conn, tenDoan, checkIn));

		String idCTDP = GetDataModel.getIDbyCheckinAndName(conn, tenDoan, checkIn);

		if (!TinhTongTienModel.checkLSDPGroup(conn, idCTDP)) {
			System.out.println("\nKhách hàng chưa ở phòng nào, vui lòng xếp phòng trước và thử lại sau!!!");
			return;
		}

		long tienPhong = tienPhong(conn, idCTDP);
		long tienDichVu = tienDichVu(conn, idCTDP);
		tongTien = tienPhong + tienDichVu;
		TinhTongTienModel.updateCTDP(conn, idCTDP, tienPhong, tienDichVu);
		System.out.println("Tổng Bill khách hàng phải trả: " + tongTien);
	}

	/**
	 * Tính tiền phòng
	 * 
	 * @param conn
	 * @param idCTDP
	 * @return
	 */
	public static long tienPhong(Connection conn, String idCTDP) {
		long tienPhong = 0;
		// Get all phòng mà đoàn đã từng ở, với ngày bắt đầu thấp nhất và ngày kết thúc
		// lớn nhất và có giá phòng.
		List<LichSuDatPhong> lsdpArr = TinhTongTienModel.getAllPhongInGroup(conn, idCTDP);

		System.out.println("Đoàn khách " + idCTDP + " có danh sách phòng như sau: ");
		for (LichSuDatPhong val : lsdpArr) {
			long dayLuuTru = ChronoUnit.DAYS.between(val.getNgayBatDau(), val.getNgayKetThuc());
			if (dayLuuTru == 0) {
				dayLuuTru = 1;
			}
			long giaPhong = dayLuuTru * val.getGiaPhong();
			System.out.print("Phòng: " + val.getiDPhong());
			System.out.print("\t || Đã lưu trú: " + dayLuuTru + " ngày");
			System.out.println("\t || Phải trả: " + giaPhong);
			tienPhong = tienPhong + giaPhong;
		}
		System.out.println("=====================================\n");
		return tienPhong;
	}

	/**
	 * Tính tiền dịch vụ
	 * 
	 * @param conn
	 * @param idCTDP
	 * @return
	 */
	public static long tienDichVu(Connection conn, String idCTDP) {
		long tienDichVu = 0;

		List<DichVu> dichVuArr = TinhTongTienModel.getAllDichVuInGroup(conn, idCTDP);

		System.out.println("Đoàn khách " + idCTDP + " có danh sách dùng dịch vụ như sau: ");
		for (DichVu val : dichVuArr) {
			System.out.println("Dịch vụ: " + val.getTenDichVu());
			System.out.print("=> Số lượng dùng: " + val.getSoLuong());
			System.out.println("|| Giá phải trả: " + val.getGiaDichVu());
			tienDichVu = tienDichVu + val.getGiaDichVu();
		}
		System.out.println("=====================================\n");
		return tienDichVu;
	}

}
