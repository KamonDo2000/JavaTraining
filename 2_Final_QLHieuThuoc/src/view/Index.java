package view;

import java.sql.Connection;

import controller.AddProductController;
import controller.UpdateProductControll;
import controller.DBUtil;
import controller.DeleteProductControll;
import controller.ShowProductController;

public class Index {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Tao ket noi
			conn = DBUtil.connectDB();

			do {
				int pick = MenuView.menu();
				switch (pick) {
				case 0:
					return;
				case 1:
					System.out.println("\n=============================");
					AddProductController.add(conn);
					continue;
				case 2:
					System.out.println("\n=============================");
					ShowProductController.showSP(conn);
					continue;
				case 3:
					System.out.println("\n=============================");
					UpdateProductControll.capNhatSoLuongBan(conn);
					continue;
				case 4:
					System.out.println("\n=============================");
					DeleteProductControll.deleteProductQuaHan(conn);
					continue;
				case 5:
					System.out.println("\n=============================");
					ShowProductController.showSPByQtyDESC(conn);
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
