package view;

import java.sql.Connection;

import utils.DButil;
import controller.ChuyenPhongControl;
import controller.DeleteDataControl;
import controller.GetDataControl;
import controller.GopPhongControl;
import controller.InsertDataControl;
import controller.ThongKeControl;
import controller.TinhTongTienControl;
import controller.UpdateDateControl;
import controller.XepPhongControl;

public class Index {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Tao ket noi
			conn = DButil.connectDB();

			do {
				int pick = MenuView.menu();
				switch (pick) {
				case 0:
					return;
				case 1:
					InsertDataControl.insertCTDP(conn);
					continue;
				case 2:
					DeleteDataControl.deleteCTDP(conn);
					continue;
				case 3:
					UpdateDateControl.updateCTDP(conn);
					continue;
				case 4:
					GetDataControl.getInforX(conn);
					continue;
				case 5:
					XepPhongControl.xepPhongKhachX(conn);
					continue;
				case 6:
					ChuyenPhongControl.chuyenPhong(conn);
					continue;
				case 7:
					GopPhongControl.gopPhong(conn);
					continue;
				case 8:
					TinhTongTienControl.tongTien(conn);
					continue;
				case 9:
					ThongKeControl.thongKe(conn);
					continue;

				default:
					System.out.println("\nKhông có lựa chọn này!!!");
				}
			} while (true);

		} finally {
			DButil.close(conn);
		}
	}

}
