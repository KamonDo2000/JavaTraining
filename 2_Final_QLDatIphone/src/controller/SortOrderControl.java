package controller;

import java.sql.Connection;
import java.util.ArrayList;

import model.Order;
import model.SortOrderModel;
import view.ShowDataView;

public class SortOrderControl {
	public static void sortOrder(Connection conn) {
		ArrayList<Order> arrOrder = SortOrderModel.sortOrder(conn);

		ShowDataView.showAllData(arrOrder);
	}
}
