package view;

import java.sql.Connection;

import controller.DBUtil;
import controller.InsertBookController;
import controller.PlusPriceController;
import controller.UpdateBookController;
import controller.GetBookController;

public class Index {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.connectDB();
			do {
				int pick = MenuView.menu();
				switch (pick) {
				case 0:
					return;
				case 1:
					System.out.println("\n====================");
					InsertBookController.inputBook(conn);
					continue;
				case 2:
					System.out.println("\n====================");
					GetBookController.getAllBook(conn);
					continue;
				case 3:
					System.out.println("\n====================");
					UpdateBookController.updateBookByID(conn);
					continue;
				case 4:
					System.out.println("\n====================");
					UpdateBookController.updateBookByTitle(conn);
					continue;
				case 5:
					System.out.println("\n====================");
					GetBookController.getBookByTitle(conn);
					continue;
				case 6:
					System.out.println("\n====================");
					GetBookController.getBookByAuthor(conn);
					continue;
				case 7:
					System.out.println("\n====================");
					GetBookController.getBookByPrice(conn);
					continue;
				case 8:
					System.out.println("\n====================");
					PlusPriceController.plusPrice(conn);
					continue;
				case 9:
					System.out.println("\n====================");
					GetBookController.getBookByPriceASC(conn);
					continue;
				case 10:
					System.out.println("\n====================");
					GetBookController.getBookByQtyDESC(conn);
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
