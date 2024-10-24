package view;

import java.util.ArrayList;

import model.BankBook;

public class ShowData {
	public static void showAllData(ArrayList<BankBook> bankBook) {
		for (BankBook val : bankBook) {
			System.out.print(val.getMaSoTK()+ " || ");
			System.out.print(val.getHoTen()+ " || ");
			System.out.print(val.getCmnd()+ " || ");
			System.out.print(val.getDiaChi()+ " || ");
			System.out.print(val.getSoDienThoai()+ " || ");
			System.out.print(val.getNgayGuiTK()+ " || ");
			System.out.print(val.getSoTien()+ " || ");
			System.out.print(val.getKyHan()+ " || ");
			System.out.println(val.getPTTaiTuc());
			System.out.println("\n===================================");
		}
	}
}
