package controller;

import java.sql.Connection;
import java.time.LocalDate;

import model.DeleteProductModel;

public class DeleteProductControll {

	public static void deleteProductQuaHan(Connection conn) {
		LocalDate day = LocalDate.now();
		DeleteProductModel.deleteProductQuaHan(conn, day);
	}

}
