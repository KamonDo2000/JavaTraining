package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import model.LichSuDatPhong;
import services.CheckDataModel;
import services.ThongKeModel;
import view.InputDateView;

public class ThongKeControl {

	/**
	 * Chức năng hiển thị số ngày lưu trú của phòng theo các tháng của năm X lợi
	 * nhuận thu về so sánh với cùng kỳ năm trước
	 * 
	 * @param conn
	 */
	public static void thongKe(Connection conn) {
		System.out.println("\n========Chức năng hiển thị số ngày lưu trú của phòng theo các tháng của năm X==========");
		System.out
				.println("======================lợi nhuận thu về so sánh với cùng kỳ năm trước======================");
		if (!CheckDataModel.checkDatPhongEmpty(conn)) {
			System.out.println("Không có đơn đặt phòng nào! ");
			return;
		}

		System.out.println("\nNhập tháng muốn thống kê:");
		int mounth = InputDateView.inputMounth();

		System.out.println("Nhập năm muốn thống kê:");
		int year = InputDateView.inputYear();

		List<LichSuDatPhong> lsdpArray = ThongKeModel.getThongKeLSDP(conn, mounth, year);
		long moneyNow = chiTiet1Thang(lsdpArray, mounth, year);
		System.out.println("\n=====================================\n");
		List<LichSuDatPhong> lsdpnamNgoaiArray = ThongKeModel.getThongKeLSDP(conn, mounth, year - 1);
		long moneyLast = chiTiet1Thang(lsdpnamNgoaiArray, mounth, year - 1);
		System.out.println("\n=====================================\n");
		if (moneyNow > moneyLast) {
			float tiLe;
			if (moneyLast == 0) {
				tiLe = 100;
			} else {
				tiLe = ((float) (moneyNow - moneyLast) / moneyLast) * 100;
			}
			String format = String.format("%.2f", tiLe);
			System.out.println("Năm " + year + " có lợi nhuận thu về cao hơn " + format + "% so với năm " + (year - 1));
			System.out.println("\n \t" + moneyNow + " so với " + moneyLast + "\n");
		} else if (moneyNow < moneyLast) {
			float tiLe;
			if (moneyNow == 0) {
				tiLe = 100;
			} else {
				tiLe = ((float) (moneyLast - moneyNow) / moneyNow) * 100;
			}
			String format = String.format("%.2f", tiLe);
			System.out
					.println("Năm " + year + " có lợi nhuận thu về thấp hơn " + format + "% so với năm " + (year - 1));
			System.out.println("\n \t" + moneyNow + " so với " + moneyLast + "\n");
		} else {
			System.out.println("Năm " + year + " có lợi nhuận thu về bằng năm " + (year - 1));
			System.out.println("\n \t" + moneyNow + " so với " + moneyLast + "\n");
		}
	}

	/**
	 * Truyền vào Tháng và Năm sau đó thống kê ngày ở trong phòng của thời gian đó
	 * 
	 * @param lsdpArray
	 * @param mounth
	 * @param year
	 * @return
	 */
	private static long chiTiet1Thang(List<LichSuDatPhong> lsdpArray, int mounth, int year) {
		if (lsdpArray.isEmpty()) {
			System.out.println("Vào tháng " + mounth + " năm " + year + " không có phòng nào có khách lưu trú!");
			return 0;
		}

		long tongTien = 0;
		System.out.println("\nVào tháng " + mounth + " năm " + year + " có các lưu trú:");
		for (LichSuDatPhong val : lsdpArray) {
			int mounthStart = val.getNgayBatDau().getMonth().getValue();
			int yearStart = val.getNgayBatDau().getYear();
			int mounthEnd = val.getNgayKetThuc().getMonth().getValue();
			int yearEnd = val.getNgayKetThuc().getYear();

			if (yearStart < year || mounthStart < mounth) {
				LocalDate date = LocalDate.of(year, mounth, 1);
				val.setNgayBatDau(date);				
			}

			if (yearEnd > year || mounthEnd > mounth) {
				LocalDate date = LocalDate.of(year, mounth, val.getNgayBatDau().lengthOfMonth());
				val.setNgayKetThuc(date);
			}

			long dayLuuTru = ChronoUnit.DAYS.between(val.getNgayBatDau(), val.getNgayKetThuc());
			if (dayLuuTru < 0) {
				dayLuuTru = dayLuuTru * (-1);
			} else if (dayLuuTru == 0) {
				dayLuuTru = 1;
			}

			long giaPhong = dayLuuTru * val.getGiaPhong();
			val.setGiaPhong(giaPhong);
			val.setNgayLuuTru(dayLuuTru);

//			System.out.print("Phòng: " + val.getiDPhong());
//			System.out.print("\t || strart: " + val.getNgayBatDau());
//			System.out.print("\t || end: " + val.getNgayKetThuc());
//			System.out.println("\t || Phải trả: " + val.getGiaPhong());
		}

		List<LichSuDatPhong> newLSDPArray = new ArrayList<>();

		for (LichSuDatPhong val : lsdpArray) {
			boolean found = false;

			// Duyệt qua danh sách LichSuDatPhong nếu tìm thấy LSDP tương ứng thì cộng dồn
			for (LichSuDatPhong summary : newLSDPArray) {
				if (summary.getiDPhong().equalsIgnoreCase(val.getiDPhong())) {
					long newNgayLuuTru = summary.getNgayLuuTru() + val.getNgayLuuTru();
					summary.setNgayLuuTru(newNgayLuuTru);

					long newGiaPhong = summary.getGiaPhong() + val.getGiaPhong();
					summary.setGiaPhong(newGiaPhong);
					found = true;
					break;
				}
			}
			// Nếu không tìm thấy LichSuDatPhong tương ứng, thêm mới vào danh sách
			if (!found) {
				LichSuDatPhong tam = new LichSuDatPhong();
				tam.setiDPhong(val.getiDPhong());
				tam.setNgayLuuTru(val.getNgayLuuTru());
				tam.setGiaPhong(val.getGiaPhong());
				newLSDPArray.add(tam);
			}
		}

		for (LichSuDatPhong val : newLSDPArray) {
			System.out.print("Phòng: " + val.getiDPhong());
			System.out.print("\t || Đã lưu trú: " + val.getNgayLuuTru() + " ngày");
			System.out.println("\t || Phải trả: " + val.getGiaPhong());
			tongTien += val.getGiaPhong();
		}

		return tongTien;

	}

}
