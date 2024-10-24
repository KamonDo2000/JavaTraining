package controller;

import java.sql.Connection;

import model.AddOrderModel;
import model.Order;
import view.InputDataView;
import view.InputTimeView;

public class AddOrderControl {
	public static void addOrder(Connection conn) {
		Order order = new Order();

		order.setMaOder(InputDataView.inputMaOder(conn));
		order.setTenKhachHang(InputDataView.inputTenKhachHang());
		order.setSoDienThoai(InputDataView.inputSoDienThoai());
		order.setTenSanPham(InputDataView.inputTenSanPham());
		order.setSoLuong(InputDataView.inputSoLuong());
		order.setDonGia(InputDataView.inputDonGia());
		order.setNgayOrder(InputTimeView.inputNgayOrder());

		AddOrderModel.addSanPham(conn, order);
	}
}
