package view;

import java.sql.Connection;

import controller.AddSTKControl;
import controller.DBUtil;
import controller.FindSTKControl;
import controller.SortSTKControl;
import controller.UpdateSTKControl;

public class Index {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Tao ket noi
			conn = DBUtil.connectDB();

			do {
				int pick = MenuView.menu(conn);
				switch (pick) {
				case 0:
					return;
				case 1:
					AddSTKControl.addSTK(conn);
					continue;
				case 2:
					FindSTKControl.findByDate(conn);
					continue;
				case 3:
					FindSTKControl.findByKH(conn);
					continue;
				case 4:
					UpdateSTKControl.updateByMaSTK(conn);
					continue;
				case 5:
					SortSTKControl.sortSTK(conn);
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
