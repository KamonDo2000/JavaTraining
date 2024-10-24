package view;

import java.util.ArrayList;

import model.Order;

public class ShowDataView {
	public static void showAllData(ArrayList<Order> order) {
		for (Order val : order) {
			System.out.println("\n===================================");
			System.out.print("ID: " + val.getMaOder());
			System.out.print(" || Ten Khach: " + val.getTenKhachHang());
			System.out.print(" || SDT: " + val.getSoDienThoai());
			System.out.print(" || Ten San Pham: " + val.getTenSanPham());
			System.out.print(" || So Luong: " + val.getSoLuong());
			System.out.print(" || Gia: " + val.getDonGia());
			System.out.println(" || Date Order: " + val.getNgayOrder().getMonth().getValue() + " - "
					+ val.getNgayOrder().getDayOfMonth() + " - " + val.getNgayOrder().getYear());

		}
	}
}
