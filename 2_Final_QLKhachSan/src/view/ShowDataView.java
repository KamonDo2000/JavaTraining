package view;

import java.util.List;

import model.ChiTietDatPhong;

public class ShowDataView {

	/**
	 * Hiển Thị Danh sách Chi Tiết Đặt Phòng
	 * 
	 * @param ctdp
	 */
	public static void showAllDataCTDP(List<ChiTietDatPhong> ctdp) {
		for (ChiTietDatPhong val : ctdp) {
			System.out.print("ID: " + val.getiDChiTietDP());
			System.out.print(" || Name: " + val.getTenDoan());
			System.out.print(" || CheckIn: " + val.getCheckIn().getDayOfMonth() + " - "
					+ val.getCheckIn().getMonth().getValue() + " - " + val.getCheckIn().getYear());
			System.out.print(" || CheckOut: " + val.getCheckOut().getDayOfMonth() + " - "
					+ val.getCheckOut().getMonth().getValue() + " - " + val.getCheckOut().getYear());
//			System.out.print(" || Tien Phong: " + val.getGiaSuDungPhong());
//			System.out.print(" || Tien DV: " + val.getGiaSuDungDichVu());
//			System.out.print(" || Tong: " + val.getTongTien());
			System.out.println();
		}
	}

	/**
	 * Hiển thị 1 chi Tiết đặt phòng
	 * 
	 * @param val
	 */
	public static void showDataCTDP(ChiTietDatPhong val) {
		System.out.print("ID: " + val.getiDChiTietDP());
		System.out.print(" || Name: " + val.getTenDoan());
		System.out.print(" || CheckIn: " + val.getCheckIn().getDayOfMonth() + " - "
				+ val.getCheckIn().getMonth().getValue() + " - " + val.getCheckIn().getYear());
		System.out.print(" || CheckOut: " + val.getCheckOut().getDayOfMonth() + " - "
				+ val.getCheckOut().getMonth().getValue() + " - " + val.getCheckOut().getYear());
		System.out.println();

	}

}
