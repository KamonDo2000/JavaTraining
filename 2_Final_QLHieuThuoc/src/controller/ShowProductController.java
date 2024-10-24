package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import model.ShowProductModel;
import view.ShowProductView;

public class ShowProductController {

	public static void showSP(Connection conn) {
		List<SanPham> arrSanPham = ShowProductModel.showProduct(conn);
		ShowProductView.show(arrSanPham);
	}

	public static void showAllSP(Connection conn) {
		List<SanPham> arrSanPham = ShowProductModel.showProduct(conn);
		ShowProductView.showAll(arrSanPham);
	}

	public static void showSPByQtyDESC(Connection conn) {
		List<SanPham> arrSanPham  = new ArrayList<>();
		arrSanPham = ShowProductModel.showProductByQtyDESC(conn);
		ShowProductView.showAll(arrSanPham);
	}

}
