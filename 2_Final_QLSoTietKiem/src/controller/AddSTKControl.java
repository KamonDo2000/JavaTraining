package controller;

import java.sql.Connection;

import model.AddSTKModel;
import model.BankBook;
import view.InputDateView;
import view.InputSTKView;

public class AddSTKControl {

	public static void addSTK(Connection conn) {
		BankBook bankBook = new BankBook();
		
		bankBook.setMaSoTK(InputSTKView.inputMaSoTK(conn));
		bankBook.setHoTen(InputSTKView.inputHoTen());
		bankBook.setCmnd(InputSTKView.inputCMND());
		bankBook.setDiaChi(InputSTKView.inputDiaChi());
		bankBook.setSoDienThoai(InputSTKView.inputSoDienThoai());
		bankBook.setNgayGuiTK(InputDateView.inputNgayGuiTK());
		bankBook.setSoTien(InputSTKView.inputSoTien());
		bankBook.setKyHan(InputSTKView.inputKyHan());
		bankBook.setPTTaiTuc(InputSTKView.inputPTTaiTuc());
		
		AddSTKModel.addSanPham(conn, bankBook);
		System.out.println("Them Thanh Cong!!");
		
	}

}
