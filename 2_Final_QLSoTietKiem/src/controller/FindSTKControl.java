package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import model.BankBook;
import model.FindSTKModel;
import view.InputDateView;
import view.InputSTKView;
import view.ShowData;

public class FindSTKControl {

	public static void findByDate(Connection conn) {
		System.out.println("Nhập ngày bắt đầu: ");
		LocalDate date1 = InputDateView.inputNgayGuiTK();

		System.out.println("Nhập ngày Kết Thúc: ");
		LocalDate date2 = InputDateView.inputNgayGuiTK();

		if (date1.isAfter(date2)) {
			System.out.println("Không có sổ tiết kiệm nào phù hợp với điều kiện");
		} else {
			ArrayList<BankBook> arrBankBook = new ArrayList<>();
			arrBankBook = FindSTKModel.findByDate(conn, date1, date2);
			if (!arrBankBook.isEmpty()) {
				ShowData.showAllData(arrBankBook);
			} else {
				System.out.println("Không có sổ tiết kiệm nào phù hợp với điều kiện");
			}
		}
	}

	public static void findByKH(Connection conn) {

		String kyHan = InputSTKView.inputKyHan();

		ArrayList<BankBook> arrBankBook = new ArrayList<>();

		arrBankBook = FindSTKModel.findByKH(conn, kyHan);
		if (!arrBankBook.isEmpty()) {
			ShowData.showAllData(arrBankBook);
		} else {
			System.out.println("Không có sổ tiết kiệm nào phù hợp với điều kiện");
		}

	}

}
