package controller;

import java.sql.Connection;
import java.util.ArrayList;

import model.ASCsoTietKiem;
import model.BankBook;
import view.ShowData;

public class SortSTKControl {
	public static void sortSTK(Connection conn) {
		ArrayList<BankBook> arrBankBooks = ASCsoTietKiem.showProductByQtyDESC(conn);

		ShowData.showAllData(arrBankBooks);
	}
}
