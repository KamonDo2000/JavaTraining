package controller;

import java.sql.Connection;
import java.time.LocalDate;

import model.CheckSTKModel;
import model.UpdateSTKModel;
import view.InputDateView;
import view.InputSTKView;

public class UpdateSTKControl {
	public static void updateByMaSTK(Connection conn) {
		
		String maSTK = InputSTKView.inputMaSTKKhongCheck();
		
		if (!CheckSTKModel.checkSTK(conn, maSTK)) {
			System.out.println("Mã sổ tiết kiệm không tồn tại");
		}else {
			LocalDate ngayGuiTK = InputDateView.inputNgayGuiTK();
			float soTien = InputSTKView.inputSoTien();
			String kyHan = InputSTKView.inputKyHan();
			
			UpdateSTKModel.updateByMaSTK(conn, maSTK, ngayGuiTK, soTien, kyHan);
		}

	}
}
