package controller;

import java.sql.Connection;
import java.time.LocalDate;

import model.UpdateOrderModel;
import view.InputDataView;

public class UpdateOrderControl {
	/**
	 * 
	 * @author HuyGiaTheDo
	 * 
	 * 
	 * @param conn
	 */
	public static void updateDiscount(Connection conn) {
		LocalDate date = LocalDate.of(2022, 10, 30);
		String tenSanPham = "IPhone 15";

		int giamGia = InputDataView.inputGiamGia();
		if (giamGia == 0) {
			System.out.println("Update Không Thành Công");
			return;
		} else {
			UpdateOrderModel.updatePrice(conn, date, tenSanPham, giamGia);
		}

	}
}
