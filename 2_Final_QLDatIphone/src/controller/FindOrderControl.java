package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import model.FindOrderModel;
import model.Order;
import view.InputTimeView;
import view.ShowDataView;

public class FindOrderControl {

	public static void findByDate(Connection conn) {
		System.out.println("\n===================================");
		System.out.println("Nhập thời gian bắt đầu tìm kiếm: ");
		LocalDate date1 = InputTimeView.inputNgayOrder();

		System.out.println("\n===================================");
		System.out.println("Nhập thời gian kết thúc tìm kiếm: ");
		LocalDate date2 = InputTimeView.inputNgayOrder();

		if (date2.isAfter(date1)) {
			System.out.println("Không có Order nào có ngày order trong khoảng thời gian trên");
		} else {
			ArrayList<Order> arrOrder = new ArrayList<>();
			arrOrder = FindOrderModel.findByDate(conn, date1, date2);
			if (!arrOrder.isEmpty()) {
				ShowDataView.showAllData(arrOrder);
			} else {
				System.out.println("Không có Order nào có ngày order trong khoảng thời gian trên");
			}
		}
	}

	public static void findByNow(Connection conn) {

		LocalDate date = LocalDate.now();

		ArrayList<Order> arrOrder = new ArrayList<>();
		arrOrder = FindOrderModel.findByDate(conn, date);
		if (!arrOrder.isEmpty()) {
			ShowDataView.showAllData(arrOrder);
		} else {
			System.out.println("Không có Order nào Trong ngày hôm nay");
		}

	}

}
