package view;

import java.sql.Connection;

import controller.AddOrderControl;
import controller.DBUtil;
import controller.FindOrderControl;
import controller.SortOrderControl;
import controller.UpdateOrderControl;

public class Index {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.connectDB();
			System.out.println("\nchào mừng bạn đến với chương trình quản lý đặt trước của shop X");
			do {
				int pick = MenuView.menu(conn);
				switch (pick) {
				case 6:
					return;
				case 1:
					AddOrderControl.addOrder(conn);
					continue;
				case 2:
					FindOrderControl.findByDate(conn);
					continue;
				case 3:
					FindOrderControl.findByNow(conn);
					continue;
				case 4:
					UpdateOrderControl.updateDiscount(conn);
					continue;
				case 5:
					SortOrderControl.sortOrder(conn);
					continue;
				default:
					System.out.println("\nKhông có lựa chọn này!!!");
				}
			} while (true);

		} finally {
			DBUtil.close(conn);
		}

	}
}
