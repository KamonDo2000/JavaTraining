package controller;

import java.sql.Connection;

import model.CheckProductModel;
import model.UpdateProductModel;
import view.InputProductView;

public class UpdateProductControll {

	public static void capNhatSoLuongBan(Connection conn) {
		String name = InputProductView.inputName();

		if (!CheckProductModel.checkName(conn, name)) {
			System.out.println("Ten san pham khong co!! ");
			return;
		}

		int soLuongBan = InputProductView.inputSoLuongDaBan();

		if (soLuongBan <= CheckProductModel.getSoLuongNhapVao(conn, name)) {
			int soLuongConLai = CheckProductModel.getSoLuongNhapVao(conn, name) - soLuongBan;
			UpdateProductModel.updateByName(conn, name, soLuongBan, soLuongConLai);
			ShowProductController.showAllSP(conn);
		} else {
			System.out.println("San pham nay khong con du so luong theo yeu cau!!");
		}
	}

}
