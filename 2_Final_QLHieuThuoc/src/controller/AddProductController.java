package controller;

import java.sql.Connection;

import model.AddProductModel;
import model.SanPham;
import view.InputDateView;
import view.InputProductView;

public class AddProductController {

	public static void add(Connection conn) {
		SanPham sanpham = new SanPham();
		
		sanpham.setId(InputProductView.inputID(conn));
		sanpham.setName(InputProductView.inputName());
		sanpham.setHanSuDung(InputDateView.inputDate());
		sanpham.setSoLuongNhapVao(InputProductView.inputSoLuongNhapVao());
		
		AddProductModel.addSanPham(conn, sanpham);
	}
	
}
